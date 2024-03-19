package br.edu.iff.gamekingdom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.edu.iff.gamekingdom.entities.GameLibrary;

@Repository
public interface GameLibraryRepository extends JpaRepository<GameLibrary, Long> {

    @Query(value = "SELECT * FROM GameLibrary WHERE id = ?1", nativeQuery = true)
    GameLibrary findLibraryById(Long id);

}
