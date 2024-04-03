<%@page import="com.emergentes.modelo.Calificaciones"%>
<%
    Calificaciones cal = (Calificaciones) request.getAttribute("miobjcal");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Calificacion</title>

        <style>
            body {
                background: #FEF8F7;

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
        <h1>Registro de Calificaciones</h1>
        <br>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%= cal.getId()%>" size="2" readonly></td>
                </tr>
                <tr>
                    <td>Nombre del Estudiante: </td>
                    <td><input type="text" name="Nombre" value="<%= cal.getNombre()%>"></td>
                </tr>
                <tr>
                    <td>Primer parcial(sobre 30 pts)</td>
                    <td><input type="text" name="PrimerParcial" value="<%= cal.getPrimerParcial()%>"></td>
                </tr>   
                <tr>
                    <td>Segundo parcial(sobre 30 pts)</td>
                    <td><input type="text" name="SegParcial" value="<%= cal.getSegParcial()%>"></td>
                </tr>
                <tr>
                    <td>Examen final(sobre 40 pts)</td>
                    <td><input type="text" name="Exfinal" value="<%= cal.getExfinal()%>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="Enviar"></td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
