package com.example.apitl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apitl.entity.TipoUsuario;


@Service
public interface TipoUsuarioService {
	List<TipoUsuario> getTipoUsuarios ();
	TipoUsuario getTipoUsuario(Integer id);
	TipoUsuario addTipoUsuario(TipoUsuario tipoUsuario);
	TipoUsuario editTipoUsuario(TipoUsuario tipoUsuario);
	void deleteTipoUsuario(Integer id);
}
