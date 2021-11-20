package com.mycompany.monoliticareto3.models.entidades;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private int edad;
    private String signo_zodiaco;
    private String idioma_nativo;
    private String idioma_aprender;
    private String usuario;
    private String password;
    private int tipo_de_cliente;
    private int tipo_usuario;
    private String hash;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String fecha_nacimiento, int edad, String signo_zodiaco, String idioma_nativo, String idioma_aprender, String usuario, String password, int tipo_de_cliente, int tipo_usuario, String hash) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.edad = edad;
        this.signo_zodiaco = signo_zodiaco;
        this.idioma_nativo = idioma_nativo;
        this.idioma_aprender = idioma_aprender;
        this.usuario = usuario;
        this.password = password;
        this.tipo_de_cliente = tipo_de_cliente;
        this.tipo_usuario = tipo_usuario;
        this.hash = hash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSigno_zodiaco() {
        return signo_zodiaco;
    }

    public void setSigno_zodiaco(String signo_zodiaco) {
        this.signo_zodiaco = signo_zodiaco;
    }

    public String getIdioma_nativo() {
        return idioma_nativo;
    }

    public void setIdioma_nativo(String idioma_nativo) {
        this.idioma_nativo = idioma_nativo;
    }

    public String getIdioma_aprender() {
        return idioma_aprender;
    }

    public void setIdioma_aprender(String idioma_aprender) {
        this.idioma_aprender = idioma_aprender;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTipo_de_cliente() {
        return tipo_de_cliente;
    }

    public void setTipo_de_cliente(int tipo_de_cliente) {
        this.tipo_de_cliente = tipo_de_cliente;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
