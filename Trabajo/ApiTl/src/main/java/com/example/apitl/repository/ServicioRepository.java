package com.example.apitl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apitl.entity.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

}
