<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Usuario</title>
        <%@include file="WEB-INF/header.jsp" %>
    </head>
    <body>
        <h3 class="text-center pb-3">Ingresar Usuario</h3>
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
                                <input type="text" id="nombre" name="nombre" placeholder="Ingrese su nombre" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <label for="apellido">Apellido:</label>
                                <input type="text" id="apellido" name="apellido" placeholder="Ingrese su apellido" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <label for="fecha_nacimiento">Fecha de Nacimiento (AAAA-MM-DD):</label>
                                <input type="text" id="fecha_nacimiento" name="fecha_nacimiento" placeholder="(AAAA-MM-DD)" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <label for="edad">Edad:</label>
                                <input type="text" id="edad" name="edad" placeholder="Ingrese su edad" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <label for="signo_zodiaco">Signo Zodiacal:</label>
                                <input type="text" id="signo_zodiaco" name="signo_zodiaco" placeholder="Ingrese su signo zodiacal" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <label for="idioma_nativo">Idioma Nativo:</label>
                                <input type="text" id="idioma_nativo" name="idioma_nativo" placeholder="Ingrese su idioma nativo" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <label for="idioma_aprender">Idioma Que Quiere Aprender:</label>
                                <input type="text" id="idioma_aprender" name="idioma_aprender" placeholder="Ingrese el idioma que quiere aprender" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <label for="usuario">Usuario:</label>
                                <input type="text" id="usuario" name="usuario" placeholder="Ingrese su usuario" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <label for="password">Contraseña:</label>
                                <input type="password" id="password" name="password" placeholder="Ingrese su contraseña" class="form-control">
                            </div>
                            
                            <div class="form-group">
                                <label for="tipo_de_cliente">Tipo de Cliente (1 Gratuito o 2 Premium):</label>
                                <input type="text" id="tipo_de_cliente" name="tipo_de_cliente" placeholder="Ingrese el número correspondiente (1 Gratuito o 2 Premium)" class="form-control">
                            </div>

                            <div class="form-group">
                                <label for="tipo_usuario">Tipo de Usuario (1 Estudiante o 2 Profesor):</label>
                                <input type="text" id="tipo_usuario" name="tipo_usuario" placeholder="Ingrese el número correspondiente (1 Estudiante o 2 Profesor)" class="form-control">
                            </div>
                        </div>
                        <div class="card-footer pb-3">
                            <div class="row">

                                <div class="col-md-6">                    
                                    <input type="submit" name="guardar" value="Guardar" class="btn btn-primary btn-block">
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
