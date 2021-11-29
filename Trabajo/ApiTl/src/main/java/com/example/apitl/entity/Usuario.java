package com.example.apitl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
    private String nombre;
    private String apellido;
    @Column(name = "fecha_nacimiento")
    private String fechaNacimiento;
    private Integer edad;
    @Column(name = "signo_zodiaco")
    private String signoZodiaco;
    @Column(name = "idioma_nativo")
    private String idiomaNativo;
    @Column(name = "idioma_aprender")
    private String idiomaAprender;
    private String usuario;
    private String password;
    
    @ManyToOne
    @JoinColumn(name = "tipo_de_cliente" )
    private Servicio tipoDeCliente;
    
    @ManyToOne
    @JoinColumn(name = "tipo_usuario" )
    private TipoUsuario tipoUsuario;

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
	public Servicio getTipoDeCliente() {
		return tipoDeCliente;
	}
	public void setTipoDeCliente(Servicio tipoDeCliente) {
		this.tipoDeCliente = tipoDeCliente;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
    
    
}
