package br.edu.iff.gamekingdom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.iff.gamekingdom.entities.GameLibrary;
import br.edu.iff.gamekingdom.entities.Person;

@Repository
public interface GameLibraryRepository extends JpaRepository<GameLibrary, Long> {

    GameLibrary findByPerson(Person person);
}