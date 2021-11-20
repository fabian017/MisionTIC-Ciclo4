<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Usuario</title>
        <%@include file="WEB-INF/header.jsp" %>
    </head>
    <body>
        <h3 class="text-center pb-3">Ingresar datos a actualizar del usuario</h3>
        <form  method="post" action="">
            <div class="row p-3">
                <div class="col-md-8 offset-md-2">
                    <div class="card">
                        <div class="card-header bg-dark">
                            <h4 class="text-white text-center">Ingresar los Datos</h4>
                        </div>
                        <div class="card-body">
                             <div class="form-group">
                                <label for="id">Id:</label>
                                <input type="text" readonly=»readonly» id="id" name="id" class="form-control" value="${usuarioSeleccionado.getId()}">
                            </div>

                            
                            <div class="form-group">
                                <label for="nombre">Nombre:</label>
                                <input type="text" id="nombre" name="nombre" class="form-control" value="${usuarioSeleccionado.getNombre()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="apellido">Apellido:</label>
                                <input type="text" id="apellido" name="apellido" class="form-control" value="${usuarioSeleccionado.getApellido()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="fecha_nacimiento">Fecha de Nacimiento (AAAA-MM-DD):</label>
                                <input type="text" id="fecha_nacimiento" name="fecha_nacimiento" class="form-control" value="${usuarioSeleccionado.getFecha_nacimiento()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="edad">Edad:</label>
                                <input type="text" id="edad" name="edad" class="form-control" value="${usuarioSeleccionado.getEdad()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="signo_zodiaco">Signo Zodiacal:</label>
                                <input type="text" id="signo_zodiaco" name="signo_zodiaco" class="form-control" value="${usuarioSeleccionado.getSigno_zodiaco()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="idioma_nativo">Idioma Nativo:</label>
                                <input type="text" id="idioma_nativo" name="idioma_nativo" class="form-control" value="${usuarioSeleccionado.getIdioma_nativo()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="idioma_aprender">Idioma Que Quiere Aprender:</label>
                                <input type="text" id="idioma_aprender" name="idioma_aprender" class="form-control" value="${usuarioSeleccionado.getIdioma_aprender()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="usuario">Usuario:</label>
                                <input type="text" id="usuario" name="usuario" class="form-control" value="${usuarioSeleccionado.getUsuario()}" >
                            </div>
                            
                            <div class="form-group">
                                <label for="password">Contraseña:</label>
                                <input type="password" id="password" name="password" class="form-control" value="${usuarioSeleccionado.getPassword()}">
                            </div>
                            
                            <div class="form-group">
                                <label for="tipo_de_cliente">Tipo de Cliente (1 Gratuito o 2 Premium):</label>
                                <input type="text" id="tipo_de_cliente" name="tipo_de_cliente" class="form-control" value="${usuarioSeleccionado.getTipo_de_cliente()}">
                            </div>

                            <div class="form-group">
                                <label for="tipo_usuario">Tipo de Usuario (1 Estudiante o 2 Profesor):</label>
                                <input type="text" id="tipo_usuario" name="tipo_usuario" class="form-control" value="${usuarioSeleccionado.getTipo_usuario()}">
                            </div>
                        </div>
                        <div class="card-footer pb-3">
                            <div class="row">

                                <div class="col-md-6">                    
                                    <input type="submit" name="actualizar" value="Actualizar" class="btn btn-primary btn-block">
                                </div>

                                <div class="col-md-6">
                                    <a href="login" class="btn btn-danger btn-block">Cancelar</a>
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
