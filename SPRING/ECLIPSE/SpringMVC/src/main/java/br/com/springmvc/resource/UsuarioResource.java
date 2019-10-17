package br.com.springmvc.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springmvc.model.Usuario;
import br.com.springmvc.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository ur;
	
	@GetMapping
	public List<Usuario> lista() {
		return ur.findAll();
	}
	
	@GetMapping("buscar/{id}")
	public Usuario buscarId(@PathVariable Long id) {
		Optional<Usuario> ou = ur.findById(id);
		if(ou.isPresent()) {
			return ou.get();
		}
		return null;
	}

	@PostMapping
	public Usuario create(@RequestBody Usuario u) {
		return ur.save(u);
	}

	@DeleteMapping
	public void delete(@RequestBody Usuario u) {
		ur.delete(u);
	}

	@PutMapping
	public Usuario update(@RequestBody Usuario u) {
		return ur.save(u);		
	}


}
