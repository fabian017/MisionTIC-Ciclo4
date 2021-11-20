package com.mycompany.monoliticareto3.controller;

import com.mycompany.monoliticareto3.db.Conexion;
import com.mycompany.monoliticareto3.models.dao.ServicioDAO;
import com.mycompany.monoliticareto3.models.entidades.Servicio;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JuanRi
 */
@WebServlet(name = "ServiciosServlet", urlPatterns = {"/servicios"})
public class ServiciosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {     
        
        response.setContentType("text/html;charset=UTF-8");
        Conexion conexion = new Conexion();
        ServicioDAO servicioDAO = new ServicioDAO(conexion);
        String opcion = request.getParameter("accion");

        opcion = (opcion == null) ? "listar" : opcion;

        if (opcion.equals("ingresarServicios.jsp")) {
            boolean ingresar = (request.getParameter("guardar") != null) ? true : false;
            if (ingresar) {
                Servicio servicio = new Servicio();
                servicio.setTipo_string(request.getParameter("nombre"));
                servicio.setPrecio(Float.parseFloat(request.getParameter("precio")));
                Servicio s = servicioDAO.add(servicio);

                response.sendRedirect("servicios");

            } else {
                request.getRequestDispatcher("ingresarServicios.jsp").forward(request, response);
            }

        }else if (opcion.equals("eliminar")) {
                int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
                if (id != 0) {
                    servicioDAO.delete(id);
                    response.sendRedirect("servicios");
                }
        }else {
            ArrayList<Servicio> servicios = servicioDAO.list();

            request.setAttribute("servicios", servicios);

            request.getRequestDispatcher("servicios.jsp").forward(request, response);

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
