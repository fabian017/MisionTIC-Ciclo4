<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Servicio</title>
        <%@include file="WEB-INF/header.jsp" %>
    </head>
    <body>
        <h3 class="text-center pb-3">Ingresar Servicio</h3>
        <form  method="post" action="">
            <div class="row p-3">
                <div class="col-md-8 offset-md-2">
                    <div class="card">
                        <div class="card-header bg-dark">
                            <h4 class="text-white text-center">Ingresar Datos</h4>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="nombre">Nombre:</label>
                                <input type="text" id="nombre" name="nombre" placeholder="Ingrese el nombre del servicio" class="form-control">
                            </div>


                            <div class="form-group">
                                <label for="nota2">Precio:</label>
                                <input type="text" id="precio" name="precio" placeholder="Ingrese el precio del servicio" class="form-control">
                            </div>
                        </div>
                        <div class="card-footer pb-3">
                            <div class="row">

                                <div class="col-md-6">                    
                                    <input type="submit" name="guardar" value="Guardar" class="btn btn-primary btn-block">
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
