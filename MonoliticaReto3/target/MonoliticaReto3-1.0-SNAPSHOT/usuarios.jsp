<%@page import="com.mycompany.monoliticareto3.models.entidades.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulo de Usuarios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <%@include file="WEB-INF/header.jsp" %>
    </head>
    <body>    
        <h2 class="text-center p-3">Este es el listado de los usuarios</h2>
        <div class="container p-3">

            <div class="jumbotron">

                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Edad</th>
                            <th>Signo Zod</th>
                            <th>I. Nativo</th>
                            <th>I. Aprender</th>
                            <th>Usuario</th>
                            <th>Tipo Usuario</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                             ArrayList<Usuario> usuarios = (ArrayList<Usuario>) request.getAttribute("usuarios");
                             int i = 0;
                             for (Usuario usuario: usuarios){
                                i++;
                            %>
                            <tr>
                                <td><%=i%></td>
                                <td><%=usuario.getNombre()%></td>
                                <td><%=usuario.getApellido()%></td>
                                <td><%=usuario.getEdad()%></td>
                                <td><%=usuario.getSigno_zodiaco()%></td>
                                <td><%=usuario.getIdioma_nativo()%></td>
                                <td><%=usuario.getIdioma_aprender()%></td>
                                <td><%=usuario.getUsuario()%></td>
                                <td><%=usuario.getTipo_usuario()%></td>
                                <td>
                                    <a href="?accion=editar&id=<%=usuario.getId()%>" class="btn btn-warning">Editar</a>
                                    <a href="?accion=eliminar&id=<%=usuario.getId()%>" 
                                       class="btn btn-danger"
                                       onclick="return confirm('Desea eliminar el usuario seleccionado')">Eliminar</a>
                                </td>
                            </tr>
                            <%
                             }
                        %>
                        
                    </tbody>
                </table>
            </div>
        </div>


    </body>
    <%@include file="WEB-INF/footer.jsp" %>
</html>
