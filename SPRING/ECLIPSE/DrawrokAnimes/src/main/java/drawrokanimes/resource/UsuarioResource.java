package drawrokanimes.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import drawrokanimes.model.Usuario;
import drawrokanimes.service.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService us;

	@GetMapping("/{id}")
	public Usuario findById(@PathVariable Long id) {
		return us.findById(id);
	}

	@GetMapping
	public List<Usuario> listAll() {
		return us.listAll();
	}

	@PostMapping
	public Usuario create(@Valid @RequestBody Usuario u) {
		return us.create(u);
	}

	@DeleteMapping
	public void delete(@Valid @RequestBody Usuario u) {
		us.delete(u);
	}

	@PutMapping
	public Usuario update(@Valid @RequestBody Usuario u) {
		return us.update(u);
	}
	
	@PutMapping("/{id}/nome")
	public Usuario updateNome(@PathVariable Long id, @RequestBody String nome) {		
		return us.updateNome(id, nome);
	}

}
