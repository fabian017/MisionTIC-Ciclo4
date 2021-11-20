<%@page import="com.mycompany.monoliticareto3.models.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulo de Matriculas</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">TinderLingo</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <% 
                        HttpSession sesionC = request.getSession();
                        if(sesionC.getAttribute("AUTORIZADO") == null){
                    %>
                    <li class="nav-item active">
                        <a class="nav-link" href="login">Login <span class="sr-only">(current)</span></a>
                    </li>
                    
                    <%        
                        }
                    %>
                    
                    
                    
                    
                    <% 
                        HttpSession sesionA = request.getSession();
                        if(sesionA.getAttribute("AUTORIZADO") != null){
                            Usuario usuario = (Usuario) sesionA.getAttribute("usuario");
                    %>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="servicios">Servicios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="usuarios">Usuarios</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="login?cerrar">Cerrar Sesión(<%=usuario.getUsuario()%>)</a>
                    </li>
                    
                    <%        
                        }
                    %>

                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </body>
</html>