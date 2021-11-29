package com.example.apitl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apitl.entity.Servicio;
import com.example.apitl.repository.ServicioRepository;
import com.example.apitl.service.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService{
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	@Override
	public List<Servicio> getServicios() {
		return this.servicioRepository.findAll();
	}

	@Override
	public Servicio getServicio(Integer id) {
		Optional<Servicio> servicio = this.servicioRepository.findById(id);
		if(servicio.isPresent()) {
			return servicio.get();
		}else {
			return new Servicio();
		}
	}

	@Override
	public Servicio addServicio(Servicio servicio) {
		return this.servicioRepository.save(servicio);
	}

	@Override
	public Servicio editServicio(Servicio servicio) {
		return this.servicioRepository.save(servicio);
	}

	@Override
	public void deleteServicio(Integer id) {
		this.servicioRepository.deleteById(id);
	}
	
}
