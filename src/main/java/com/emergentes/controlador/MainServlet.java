package com.emergentes.controlador;

import com.emergentes.modelo.Calificaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        
        Calificaciones objcal = new Calificaciones();
        int id, pos;
        
        HttpSession ses = request.getSession();
        ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>)ses.getAttribute("listacal");
        
        switch (op) {
            case "nuevo":
                //Enviar objeto vacio a editar
                request.setAttribute("miobjcal", objcal);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                //Enviar objeto a editar pero con contenido
                id = Integer.parseInt(request.getParameter("id"));
                //Averiguar la posicion del elemento en la lista
                pos = BuscarPorIndice(request,id);
                //obtener el objeto
                objcal = lista.get(pos);
                request.setAttribute("miobjcal", objcal);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break; 
            case "eliminar":
                
                id = Integer.parseInt(request.getParameter("id"));
                //Averiguar la posicion del elemento en la lista
                pos = BuscarPorIndice(request,id);
                if(pos >= 0){
                    lista.remove(pos);
                }
                request.setAttribute("listacal", lista);
                response.sendRedirect("index.jsp");
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>)ses.getAttribute("listacal");
        Calificaciones objcal = new Calificaciones();
        objcal.setId(id);
        objcal.setNombre(request.getParameter("Nombre"));
        objcal.setPrimerParcial(Integer.parseInt(request.getParameter("PrimerParcial")));
        objcal.setSegParcial(Integer.parseInt(request.getParameter("SegParcial")));
        objcal.setExfinal(Integer.parseInt(request.getParameter("Exfinal")));
        if(id == 0){
            //NUEVO REGISTRO
            int idNuevo = obtenerId(request);
            objcal.setId(idNuevo);
            lista.add(objcal);
        }
        else{
            //EDICION DE REGISTRO
            int pos = BuscarPorIndice(request, id);
            lista.set(pos, objcal);
        }
        request.setAttribute("listacal", lista);
        response.sendRedirect("index.jsp");
    }
    
    public int BuscarPorIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>) ses.getAttribute("listacal");
        
        int pos = -1;
        
        if(lista != null){
            for (Calificaciones ele : lista) {
                ++pos;
                if(ele.getId()==id){
                    break;
                }
            }
        }
        return pos;
    }
    
    public int obtenerId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Calificaciones> lista = (ArrayList<Calificaciones>) ses.getAttribute("listacal");
        
        //buscar el ultimo id
        int idn = 0;
        if (lista != null){
        for (Calificaciones ele : lista) {
            idn = ele.getId();
        }
        }
        return idn + 1;
    }

}
