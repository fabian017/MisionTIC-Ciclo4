package com.example.apitl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apitl.entity.Usuario;

@Service
public interface UsuarioService {
	List <Usuario> getUsuarios();
	Usuario getUsuario(Integer id);
	Usuario addUsuario(Usuario usuario);
	Usuario editUsuario(Usuario usuario);
	void deleteUsuario(Integer id);
	Usuario registrar(Usuario usuario);
	Usuario login(Usuario usuario);
}
