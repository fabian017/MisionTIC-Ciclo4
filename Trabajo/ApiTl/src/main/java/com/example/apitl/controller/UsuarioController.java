package com.example.apitl.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.apitl.entity.Usuario;
import com.example.apitl.filter.RequestFilter;
import com.example.apitl.service.UsuarioService;
import com.example.apitl.util.UsuarioUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> getUsuarios(){
		return this.usuarioService.getUsuarios();
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	private Usuario addUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.registrar(usuario);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	private UsuarioUtil login(@RequestBody Usuario usuario) {
		Usuario u = this.usuarioService.login(usuario); 
		if(u==null) {
			return new UsuarioUtil();
		}else {
			UsuarioUtil usuarioUtil = new UsuarioUtil();
			usuarioUtil.setId(u.getId());
			usuarioUtil.setNombre(u.getNombre());
			usuarioUtil.setApellido(u.getApellido());
			usuarioUtil.setUsuario(u.getUsuario());
			
			long tiempo =System.currentTimeMillis();
			String token = Jwts.builder()
							   .signWith(SignatureAlgorithm.HS256, RequestFilter.KEY)
							   .setSubject(u.getUsuario())
							   .setIssuedAt(new Date(tiempo))
							   .setExpiration(new Date(tiempo + 900000))
							   .claim("usuario", u.getUsuario())
							   .claim("id", u.getId())
							   .compact();
			
			usuarioUtil.setToken(token);
			
			return usuarioUtil;
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Usuario getUsuario(@PathVariable("id") Integer id) {
		return this.usuarioService.getUsuario(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	private Usuario editUsuario(@RequestBody Usuario usuario) {
		return this.usuarioService.editUsuario(usuario);
	}
	
	@RequestMapping(value = "{id}", method =  RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUsuario(@PathVariable("id")Integer id) {
		this.usuarioService.deleteUsuario(id);
		return ResponseEntity.ok(null);
	}
	
}
