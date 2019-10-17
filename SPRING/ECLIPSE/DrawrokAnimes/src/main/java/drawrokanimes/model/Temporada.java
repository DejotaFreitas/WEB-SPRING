package drawrokanimes.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Temporada implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private Integer numero;

	@NotNull
	private String nome;

	@ManyToOne
	private Anime anime;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "temporada")
	private Map<Integer, Episodio> episodios;

	// =========CONSTRUCTOR===========\\

	public Temporada() {
		episodios = new HashMap<Integer, Episodio>();
	}

	public Temporada(@NotNull Integer numero, @NotNull String nome, Anime anime) {
		episodios = new HashMap<Integer, Episodio>();
		this.numero = numero;
		this.nome = nome;
		this.anime = anime;
	}

	// =========CUSTOM===========\\

	public Map<Integer, Episodio> getEpisodios() {
		return Collections.unmodifiableMap(episodios);
	}

	public void saveEpisodios(Episodio episodio) {
		episodio.setTemporada(this);
		episodios.put(episodio.getNumero(), episodio);
	}

	public void deleteEpisodios(Episodio episodio) {
		episodios.remove(episodio.getNumero());
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Anime getAnime() {
		return anime;
	}

	public void setAnime(Anime anime) {
		this.anime = anime;
	}

	// =========OUTERS===========\\

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Temporada other = (Temporada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Temporada [id=" + id + ", nome=" + nome + "]";
	}

}
