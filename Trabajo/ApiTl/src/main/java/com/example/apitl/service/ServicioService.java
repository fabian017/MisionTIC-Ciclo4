package com.example.apitl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apitl.entity.Servicio;

@Service
public interface ServicioService {
	List<Servicio> getServicios ();
	Servicio getServicio(Integer id);
	Servicio addServicio(Servicio servicio);
	Servicio editServicio(Servicio servicio);
	void deleteServicio(Integer id);
}
