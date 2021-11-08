function validarDatos(){

    var formulario = document.getElementById("pqrs");
    var informacionCorrecta = true;

    if(formulario.nombre.value=="")
    {
        formulario.nombre.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("parrafoValidarNombre");
        alert("Por favor, ingresa tu nombre.");
        formulario.nombre.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.nombre.setAttribute("class", "form-control is-valid");
    }

    if(formulario.email.value=="")
    {
        formulario.email.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("parrafoValidarCorreo");
        alert("Por favor, ingresa tu correo.");
        formulario.nombre.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.email.setAttribute("class", "form-control is-valid");
    }

    if(formulario.telefono.value=="")
    {
        formulario.telefono.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("parrafoValidarTelefono");
        alert("Por favor, ingresa tu telefono.");
        formulario.email.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.telefono.setAttribute("class", "form-control is-valid");
    }

    if(formulario.reclamo.value=="")
    {
        formulario.reclamo.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("parrafoValidarReclamo");
        alert("Por favor, ingresa tu reclamo.");
        formulario.telefono.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.reclamo.setAttribute("class", "form-control is-valid");
    }

}