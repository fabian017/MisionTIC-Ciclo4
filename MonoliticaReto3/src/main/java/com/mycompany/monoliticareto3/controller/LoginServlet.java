package com.mycompany.monoliticareto3.controller;

import com.mycompany.monoliticareto3.db.Conexion;
import com.mycompany.monoliticareto3.models.dao.UsuarioDAO;
import com.mycompany.monoliticareto3.models.entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        Conexion conexion = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexion);
        String opcion = request.getParameter("accion");
        
        opcion = (opcion==null) ? "listar" :  opcion;
        
        if(opcion.equals("ingresarUsuario.jsp")){
           System.out.println("Entre a Case IU");
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
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                    
                } else {
                    request.getRequestDispatcher("ingresarUsuario.jsp").forward(request, response);
                }
            
        }
        
        if(request.getParameter("cerrar") != null){
            sesion.invalidate();
        }

        if(request.getParameter("entrar") != null){
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            
           
            Usuario u = usuarioDAO.login(usuario, password);
            if(u.getId()!=0){
                sesion.setAttribute("AUTORIZADO", "SI");
                u.setPassword("");
                sesion.setAttribute("usuario", u);
                response.sendRedirect("servicios");
                return;
            }
        }
        
        request.getRequestDispatcher("login.jsp").forward(request, response);
       
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
