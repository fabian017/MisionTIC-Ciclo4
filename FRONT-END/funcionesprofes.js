function guardardatos(){
    var formulario = document.getElementById("conf_profesor");
    var informacionCorrecta = true;
 
    if(formulario.Nombres.value=="")
    {
        formulario.Nombres.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("guestname");
        alert("Por favor, ingresa tu nombre.");
        validarParrafo.setAttribute("class", "text-danger");
        formulario.Nombres.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.Nombres.setAttribute("class", "form-control is-valid");
    }
 
    if(formulario.Apellidos.value=="")
    {
        formulario.Apellidos.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("guestlastname");
        alert("Por favor, ingresa tu Apellido.");
        validarParrafo.setAttribute("class", "text-danger");
        formulario.Apellidos.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.Apellidos.setAttribute("class", "form-control is-valid");
    }
 
    if(formulario.email.value=="")
    {
        formulario.email.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("guestmail");
        alert("Por favor, ingresa tu Email.");
        validarParrafo.setAttribute("class", "text-danger");
        formulario.email.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.email.setAttribute("class", "form-control is-valid");
    }
 
    if(formulario.contraseña.value=="")
    {
        formulario.contraseña.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("guestpassword");
        alert("Por favor, ingresa tu Contraseña.");
        validarParrafo.setAttribute("class", "text-danger");
        formulario.email.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.contraseña.setAttribute("class", "form-control is-valid");
    }
 
    if(formulario.hobbies.value=="")
    {
        formulario.hobbies.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("guesthobbies");
        alert("Por favor, elija tus hobbies.");
        validarParrafo.setAttribute("class", "text-danger");
        formulario.hobbies.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.contraseña.setAttribute("class", "form-control is-valid");
    }
 
    if(formulario.idiomas.value=="")
    {
        formulario.idiomas.setAttribute("class", "form-control is-invalid");
        var validarParrafo = document.getElementById("guestlanguages");
        alert("Por favor, seleccione el idioma que maneja.");
        validarParrafo.setAttribute("class", "text-danger");
        formulario.idiomas.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.idiomas.setAttribute("class", "form-control is-valid");
    }
 
    if(formulario.foto.value=="")
    {
        formulario.foto.setAttribute("class", "form-control is-valid");
        var validarParrafo = document.getElementById("guestphoto");
        alert("Por favor, seleccione una foto de perfil.");
        validarParrafo.setAttribute("class", "text-danger");
        formulario.foto.focus();
        informacionCorrecta = false;
    }
    else{
        formulario.foto.setAttribute("class", "form-control is-valid");
    }
}