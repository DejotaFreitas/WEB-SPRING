package drawrokanimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import drawrokanimes.model.Episodio;

public interface EpisodioRepository extends JpaRepository<Episodio, Long> {
	

}
