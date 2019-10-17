package br.com.springmvc.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springmvc.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public ArrayList<Usuario> findByNome(String nome);
	public ArrayList<Usuario> findByEmail(String email);

}
