package com.example.apitl.util;


public class UsuarioUtil {
	private Integer id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private Integer edad;
    private String signoZodiaco;
    private String idiomaNativo;
    private String idiomaAprender;
    private String usuario;
    private String password;
    private String token;
	
    public UsuarioUtil() {
		super();
	}

	public UsuarioUtil(Integer id, String nombre, String apellido, String fechaNacimiento, Integer edad,
			String signoZodiaco, String idiomaNativo, String idiomaAprender, String usuario, String password,
			String token) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.signoZodiaco = signoZodiaco;
		this.idiomaNativo = idiomaNativo;
		this.idiomaAprender = idiomaAprender;
		this.usuario = usuario;
		this.password = password;
		this.token = token;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getSignoZodiaco() {
		return signoZodiaco;
	}

	public void setSignoZodiaco(String signoZodiaco) {
		this.signoZodiaco = signoZodiaco;
	}

	public String getIdiomaNativo() {
		return idiomaNativo;
	}

	public void setIdiomaNativo(String idiomaNativo) {
		this.idiomaNativo = idiomaNativo;
	}

	public String getIdiomaAprender() {
		return idiomaAprender;
	}

	public void setIdiomaAprender(String idiomaAprender) {
		this.idiomaAprender = idiomaAprender;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
    
    
    
}
