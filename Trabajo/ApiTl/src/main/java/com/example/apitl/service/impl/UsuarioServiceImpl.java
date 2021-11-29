package com.example.apitl.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apitl.entity.Usuario;
import com.example.apitl.repository.UsuarioRepository;
import com.example.apitl.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@Override
	public Usuario registrar(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario login(Usuario usuario) {
		return this.usuarioRepository.getByUsuarioAndPassword(usuario.getUsuario(), usuario.getPassword());
	}

	@Override
	public List<Usuario> getUsuarios() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario getUsuario(Integer id) {
		Optional<Usuario> usuario = this.usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return usuario.get();
		}else {
			return new Usuario();
		}
	}

	@Override
	public Usuario addUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario editUsuario(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuario(Integer id) {
		this.usuarioRepository.deleteById(id);
		
	}

}
