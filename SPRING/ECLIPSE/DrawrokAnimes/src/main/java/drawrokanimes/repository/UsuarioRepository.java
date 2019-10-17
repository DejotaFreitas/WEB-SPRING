package drawrokanimes.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import drawrokanimes.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public ArrayList<Usuario> findByNome(String nome);
	public ArrayList<Usuario> findByEmail(String email);

}
