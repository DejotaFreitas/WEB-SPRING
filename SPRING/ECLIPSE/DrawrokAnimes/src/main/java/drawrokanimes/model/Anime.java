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
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Anime implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String nome;	
	
	@NotNull
	private String sinopse;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "anime")
	private Map<Integer, Temporada> temporadas;
	
	// =========CONSTRUCTOR===========\\
	
	public Anime() {
		temporadas = new HashMap<Integer, Temporada>();
	}

	public Anime(@NotNull String nome, @NotNull String sinopse) {
		temporadas = new HashMap<Integer, Temporada>();
		this.nome = nome;
		this.sinopse = sinopse;
	}
	
	// =========CUSTOM===========\\

	public Map<Integer, Temporada> getTemporadas() {
		return Collections.unmodifiableMap(temporadas);
	}
	public void saveTemporada(Temporada temporada) {
		temporada.setAnime(this);
		temporadas.put(temporada.getNumero(), temporada);
	}

	public void deleteTemporada(Temporada temporada) {
		temporadas.remove(temporada.getNumero());
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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
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
		Anime other = (Anime) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Anime [id=" + id + ", nome=" + nome + "]";
	}

}
