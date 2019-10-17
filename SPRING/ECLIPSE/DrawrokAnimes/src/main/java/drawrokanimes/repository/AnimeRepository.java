package drawrokanimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import drawrokanimes.model.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
	

}
