package com.example.apitl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.apitl.entity.Servicio;
import com.example.apitl.service.ServicioService;

@RestController
@RequestMapping("/servicios")
@CrossOrigin("*")
public class ServicioController {
	@Autowired
	private ServicioService servicioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Servicio> getServicios(){
		return this.servicioService.getServicios();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	private Servicio addServicio(@RequestBody Servicio servicio) {
		return this.servicioService.addServicio(servicio);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	private Servicio editServicio(@RequestBody Servicio servicio) {
		return this.servicioService.editServicio(servicio);
	}
	
	@RequestMapping(value = "{id}", method =  RequestMethod.DELETE)
	public ResponseEntity<Void> deleteServicio(@PathVariable("id")Integer id) {
		this.servicioService.deleteServicio(id);
		return ResponseEntity.ok(null);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Servicio getServicio(@PathVariable("id") Integer id) {
		return this.servicioService.getServicio(id);
	}
}
