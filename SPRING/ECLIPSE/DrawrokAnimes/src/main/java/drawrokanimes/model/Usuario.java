package drawrokanimes.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import drawrokanimes.model.enumeration.CategoriaUsuario;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	@NotNull
	private String senha;

	 @NotNull
	 private LocalDate dataCadastro;

	@NotNull
	@Enumerated(EnumType.STRING)
	private CategoriaUsuario categoria;

	// @Embedded
	// private Perfil perfil;

	@ManyToMany
	private Map<Long, Anime> animes;

	// =========CONSTRUCTOR===========\\

	public Usuario() {
		animes = new HashMap<Long, Anime>();
	}

	public Usuario(@NotNull String nome, @NotNull String email, @NotNull String senha) {
		animes = new HashMap<Long, Anime>();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	// =========CUSTOM===========\\

	public Map<Long, Anime> getAnimes() {
		return Collections.unmodifiableMap(animes);
	}

	public void saveAnime(Anime anime) {
		animes.put(anime.getId(), anime);
	}

	public void deleteAnime(Anime anime) {
		animes.remove(anime.getId());
	}

	// =========GET AND SET===========\\

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public CategoriaUsuario getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaUsuario categoria) {
		this.categoria = categoria;
	}
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	// =========OUTERS===========\\


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + "]";
	}

}
