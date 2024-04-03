<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Calificaciones"%>
<%
    if (session.getAttribute("listacal") == null) {
        ArrayList<Calificaciones> lisaux = new ArrayList<Calificaciones>();
        session.setAttribute("listacal", lisaux);
    }
    ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>) session.getAttribute("listacal");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Calificaciones</title>
        <style>
            body {
                background: #FEF8F7;

            }
            fieldset{
                width:400px;
                align-content: center;
                align: center;
            }
            table{
                width: 500px;
                border-collapse: collapse;
                border-color: yellow;
            }
            th{
                border-color: yellow;
                font-size: 20px;
                background-color: goldenrod;
            }
            td{
                border-color: yellow;
                background-color: khaki;
            }

        </style> 
    </head>
    <body>
    <center>
        <fieldset >
            <legend></legend>
            <p>PRIMER PARCIAL TEM-742 <br>
                Nombre: Ruth Pairumani Choque<br>
                Carnet: 9199405<br></p>
        </fieldset>
        <h1>Registro de Calificaciones</h1>
        
        <a href="MainServlet?op=nuevo">Nuevo</a>
        
        <table>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(40)</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if (lista != null) {
                    for (Calificaciones item : lista) {

            %>
            <tr>
                <td> <%= item.getId()%> </td>
                <td> <%= item.getNombre()%> </td>
                <td> <%= item.getPrimerParcial()%> </td>
                <td> <%= item.getSegParcial()%> </td>
                <td> <%= item.getExfinal()%> </td>
                <td>
                    <a href="MainServlet?op=editar&id=<%= item.getId()%>">Editar</a>
                </td>
                <td>
                    <a href="MainServlet?op=eliminar&id=<%= item.getId()%>"
                       onclick="return(confirm('Esta seguro de eliminar??'))">Eliminar</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </center>
</body>
</html>
