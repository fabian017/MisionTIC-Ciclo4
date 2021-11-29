package com.example.apitl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.apitl.entity.TipoUsuario;
import com.example.apitl.service.TipoUsuarioService;

@RestController
@RequestMapping("/tipo_usuarios")
@CrossOrigin("*")
public class TipoUsuarioController {
	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<TipoUsuario> getTipoUsuarios(){
		return this.tipoUsuarioService.getTipoUsuarios();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private TipoUsuario addTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return this.tipoUsuarioService.addTipoUsuario(tipoUsuario);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	private TipoUsuario editTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return this.tipoUsuarioService.editTipoUsuario(tipoUsuario);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public TipoUsuario getTipoUsuario(@PathVariable("id") Integer id) {
		return this.tipoUsuarioService.getTipoUsuario(id);
	}
	
	@RequestMapping(value = "{id}", method =  RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTipoUsuario(@PathVariable("id")Integer id) {
		this.tipoUsuarioService.deleteTipoUsuario(id);
		return ResponseEntity.ok(null);
	}
	
}
