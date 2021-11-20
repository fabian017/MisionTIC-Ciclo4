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
        int id;
        opcion = (opcion == null) ? "listar" : opcion;
        
        switch (opcion) {
            case "ingresarUsuario.jsp":
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
                    response.sendRedirect("usuarios");
                    
                } else {
                    request.getRequestDispatcher("ingresarUsuario.jsp").forward(request, response);
                }   break;
            case "editar":
                id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
                Usuario usuario = usuarioDAO.obtenerUsuario(id);
                request.setAttribute("usuarioSeleccionado", usuario);
                
                boolean actualizarS = (request.getParameter("actualizar") != null) ? true : false;
                    if(actualizarS){
                        Usuario usuario1 = new Usuario();
                        String nombreUpdate = request.getParameter("nombre");
                        String apellidoUpdate = request.getParameter("apellido");
                        String fechaNacimientoUpdate = request.getParameter("fecha_nacimiento");
                        int edadUpdate = (Integer.parseInt(request.getParameter("edad")));
                        String signoZodiacoUpdate = request.getParameter("signo_zodiaco");
                        String idiomaNativoUpdate = request.getParameter("idioma_nativo");
                        String idiomaAprenderUpdate = request.getParameter("idioma_aprender");
                        String usuarioUpdate = request.getParameter("usuario");
                        String passwordUpdate = request.getParameter("password");
                        int tipoDeClienteUpdate = (Integer.parseInt(request.getParameter("tipo_de_cliente")));
                        int tipoUsuarioUpdate = (Integer.parseInt(request.getParameter("tipo_usuario")));
                        usuario1.setNombre(nombreUpdate);
                        usuario1.setApellido(apellidoUpdate);
                        usuario1.setFecha_nacimiento(fechaNacimientoUpdate);
                        usuario1.setEdad(edadUpdate);
                        usuario1.setSigno_zodiaco(signoZodiacoUpdate);
                        usuario1.setIdioma_nativo(idiomaNativoUpdate);
                        usuario1.setIdioma_aprender(idiomaAprenderUpdate);
                        usuario1.setUsuario(usuarioUpdate);
                        usuario1.setPassword(passwordUpdate);
                        usuario1.setTipo_de_cliente(tipoDeClienteUpdate);
                        usuario1.setTipo_usuario(tipoUsuarioUpdate);
                        usuario1.setId(id);
                        usuarioDAO.edit(usuario1);
                        response.sendRedirect("usuarios");
                    }else{
                        request.getRequestDispatcher("editarUsuarios.jsp").forward(request, response);
                    }

                break;
            case "eliminar":
                id = (request.getParameter("id") != null) ? Integer.parseInt(request.getParameter("id")) : 0;
                if (id != 0) {
                    usuarioDAO.delete(id);
                    response.sendRedirect("usuarios");
                }
                break;
            default:
                ArrayList<Usuario> usuarios = usuarioDAO.list();
                request.setAttribute("usuarios", usuarios);
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                break;
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
