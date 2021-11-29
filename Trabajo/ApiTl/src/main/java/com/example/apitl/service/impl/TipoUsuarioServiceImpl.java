package com.example.apitl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.apitl.entity.TipoUsuario;
import com.example.apitl.repository.TipoUsuarioRepository;
import com.example.apitl.service.TipoUsuarioService;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;

	@Override
	public List<TipoUsuario> getTipoUsuarios() {
		return this.tipoUsuarioRepository.findAll();
	}

	@Override
	public TipoUsuario getTipoUsuario(Integer id) {
		Optional<TipoUsuario> tipoUsuario = this.tipoUsuarioRepository.findById(id);
		if(tipoUsuario.isPresent()) {
			return tipoUsuario.get();
		}else {
			return new TipoUsuario();
		}
	}

	@Override
	public TipoUsuario addTipoUsuario(TipoUsuario tipoUsuario) {
		return this.tipoUsuarioRepository.save(tipoUsuario);
	}

	@Override
	public TipoUsuario editTipoUsuario(TipoUsuario tipoUsuario) {
		return this.tipoUsuarioRepository.save(tipoUsuario);
	}

	@Override
	public void deleteTipoUsuario(Integer id) {
		this.tipoUsuarioRepository.deleteById(id);
		
	}
	
	
}
