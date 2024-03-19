package br.edu.iff.gamekingdom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.iff.gamekingdom.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}

