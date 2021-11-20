package com.mycompany.monoliticareto3.controller;

import com.mycompany.monoliticareto3.db.Conexion;
import com.mycompany.monoliticareto3.models.dao.UsuarioDAO;
import com.mycompany.monoliticareto3.models.entidades.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UsuariosServlet", urlPatterns = {"/usuarios"})
public class UsuariosServlet extends HttpServlet {

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
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
        String opcion = request.getParameter("accion");
        
        opcion = (opcion == null) ? "listar" : opcion;
        
        if (opcion.equals("ingresarUsuario.jsp")) {
            boolean ingresar = (request.getParameter("guardar") != null) ? true : false;
            if (ingresar) {
                Usuario usuario = new Usuario();
                usuario.setNombre(request.getParameter("nombre"));
                usuario.setApellido(request.getParameter("apellido"));
                usuario.setFecha_nacimiento(request.getParameter("fecha_nacimiento"));
                usuario.setEdad(Integer.parseInt(request.getParameter("edad")));
                usuario.setSigno_zodiaco(request.getParameter("signo_zodiaco"));
                usuario.setIdioma_nativo(request.getParameter("idioma_nativo"));
                usuario.setIdioma_aprender(request.getParameter("idioma_aprender"));
                usuario.setUsuario(request.getParameter("usuario"));
                usuario.setPassword(request.getParameter("password"));
                usuario.setTipo_de_cliente(Integer.parseInt(request.getParameter("tipo_de_cliente")));
                usuario.setTipo_usuario(Integer.parseInt(request.getParameter("tipo_usuario")));
                Usuario u = usuarioDAO.add(usuario);

                response.sendRedirect("usuarios");

            } else {
                request.getRequestDispatcher("ingresarUsuario.jsp").forward(request, response);
            }

        }else if (opcion.equals("eliminar")) {
                int id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
                if (id != 0) {
                    usuarioDAO.delete(id);
                    response.sendRedirect("usuarios");
                }
        }else {
            ArrayList<Usuario> usuarios = usuarioDAO.list();

            request.setAttribute("usuarios", usuarios);

            request.getRequestDispatcher("usuarios.jsp").forward(request, response);

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
