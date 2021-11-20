<%@page import="com.mycompany.monoliticareto3.models.entidades.Servicio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection" %>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modulo de Servicios</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <%@include file="WEB-INF/header.jsp" %>
    </head>
    <body>     
        <h2 class="text-center p-3">Este es el listado de los servicios</h2>
        <div class="container p-3">

            <div class="jumbotron">
                <div class="alert alert-primary"> 
                    <a href="?accion=ingresarServicios.jsp" class="btn btn-primary">Ingresar</a>
                </div>

                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Precio</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                             ArrayList<Servicio> servicios = (ArrayList<Servicio>) request.getAttribute("servicios");
                             int i = 0;
                             for (Servicio servicio: servicios){
                                i++;
                            %>
                            <tr>
                                <td><%=i%></td>
                                <td><%=servicio.getTipo_string()%></td>
                                <td><%=servicio.getPrecio()%></td>
                                <td>
                                    <a href="#" class="btn btn-warning">Editar</a>
                                    <a href="?accion=eliminar&id=<%=servicio.getId()%>" 
                                       class="btn btn-danger"
                                       onclick="return confirm('Desea eliminar el servicio seleccionado')">Eliminar</a>
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
