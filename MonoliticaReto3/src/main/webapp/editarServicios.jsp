<%@page import="com.mycompany.monoliticareto3.models.entidades.Servicio"%>
<%@page import="com.mycompany.monoliticareto3.db.Conexion"%>
<%@page import="com.mycompany.monoliticareto3.models.dao.ServicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Servicio</title>
        <%@include file="WEB-INF/header.jsp" %>
    </head>
    <body>
        <h3 class="text-center pb-3">Actualizar Servicio</h3>
        <form  method="post" action="">
            <div class="row p-3">
                <div class="col-md-8 offset-md-2">
                    <div class="card">
                        <div class="card-header bg-dark">
                            <h4 class="text-white text-center">Ingresar Datos</h4>
                        </div>
                        <div class="card-body">

                             <div class="form-group">
                                <label for="id">Id:</label>
                                <input type="text" readonly=»readonly» id="id" name="id" class="form-control" value="${servicioSeleccionado.getId()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="nombre">Nombre:</label>
                                <input type="text" id="nombre" name="nombre" class="form-control" value="${servicioSeleccionado.getTipo_string()}">
                            </div>


                            <div class="form-group">
                                <label for="nota2">Precio:</label>
                                <input type="text" id="precio" name="precio" class="form-control" value="${servicioSeleccionado.getPrecio()}">
                            </div>

                        </div>
                        <div class="card-footer pb-3">
                            <div class="row">

                                <div class="col-md-6">                    
                                    <input type="submit" name="actualizar" value="Actualizar" class="btn btn-primary btn-block">
                                </div>

                                <div class="col-md-6">
                                    <a href="servicios" class="btn btn-danger btn-block">Cancelar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>  
        </form>
    </body>
     <%@include file="WEB-INF/footer.jsp" %>
</html>
