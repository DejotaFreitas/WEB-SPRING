package drawrokanimes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import drawrokanimes.model.Usuario;
import drawrokanimes.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository ur;
	
	public Usuario findById(Long id) {
		Optional<Usuario> ou = ur.findById(id);
		if(ou.isPresent())
			return ou.get();
		return null;
	}
	
	public List<Usuario> listAll() {
		return ur.findAll();
	}
	
	public Usuario create(Usuario u) {
		return ur.save(u);
	}

	public void delete(Usuario u) {
		ur.delete(u);
	}

	public Usuario update(Usuario u) {
		Usuario uu = findById(u.getId());
		if(null != uu) {
			BeanUtils.copyProperties(u, uu, "id");
			return ur.save(uu);	
		}
		return null;
	}
	
	public Usuario updateNome(Long id, String nome) {
		Usuario uu = findById(id);
		if(null != uu) {
			uu.setNome(nome);
			return ur.save(uu);	
		}
		return null;
	}

}
