package com.dejota.zaprojeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dejota.zaprojeto.model.Usuario;
import com.dejota.zaprojeto.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepositorio ur;
	

	@GetMapping("")
	public List<Usuario> pesquisar() {
		return ur.findAll();
	}
	

	// @PutMapping("/{id}") @PathVariable
	@RequestMapping("/find-id/{id}")
	@ResponseBody
	public String searchUser(@PathVariable long id) {
		try {
			Optional<Usuario> optUser = ur.findById(id);
			if (optUser.isPresent()) {
				Usuario user = optUser.get();
				return user.toString();
			}
			throw new Exception("USUARIO NÃO ENCONTRADO");
		} catch (Exception ex) {
			return "ERROR: " + ex.toString();
		}
	}

	// @PostMapping @PathVariable
	@RequestMapping("/create")
	@ResponseBody
	public String create(String nome, String email) {
		String userId = "";
		try {
			Usuario user = new Usuario(nome, email);
			ur.save(user);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "Erro: " + ex.toString();
		}
		return "USUARIO CRIADO COM SUCESSO!!! ID = " + userId;
	}

	// @DeleteMapping("/{id}") @PathVariable
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Usuario user = new Usuario(id);
			ur.delete(user);
		} catch (Exception ex) {
			return "ERROR:" + ex.toString();
		}
		return "USUARIO DELETADO COM SUCESSO!!!";
	}

	// @PutMapping("/{id}") @PathVariable
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String nome, String email) {
		try {
			Optional<Usuario> optUser = ur.findById(id);
			if (optUser.isPresent()) {
				Usuario user = optUser.get();
				user.setNome(nome);
				user.setEmail(email);
				ur.save(user);
			}

		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId = "";
		try {
			Usuario user = ur.findByEmail(email);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

}
