package com.dejota.zaprojeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.dejota.zaprojeto.model.Usuario;

@Transactional
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	
	

}
