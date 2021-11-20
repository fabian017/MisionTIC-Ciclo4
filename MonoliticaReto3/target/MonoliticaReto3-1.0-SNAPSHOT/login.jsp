<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Servicio</title>
        <%@include file="WEB-INF/header.jsp" %>
    </head>
    <body>
        <h3 class="text-center p-2">Login</h3>
        <form  method="post" action="login">
            <div class="row p-3">
                <div class="col-md-8 offset-md-2">
                    <div class="card">
                        <div class="card-header bg-dark">
                            <h4 class="text-white text-center">Datos de Ingreso</h4>
                        </div>
                        <div class="card-body">
                            <div class="form-group">
                                <label for="usuario">Usuario:</label>
                                <input type="text" id="usuario" name="usuario" placeholder="Ingrese su usuario" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="password">Contraseña:</label>
                                <input type="password" id="password" name="password" placeholder="Ingrese su contraseña" class="form-control">
                            </div>
                        </div>
                        <div class="card-footer pb-3">
                            <div class="row">

                                <div class="col-md-6">                    
                                    <input type="submit" name="entrar" value="Entrar" class="btn btn-primary btn-block">
                                </div>

                                <div class="col-md-6">
                                    <a href="?accion=ingresarUsuario.jsp" class="btn btn-danger btn-block">Registrar</a>
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
