package br.edu.iff.gamekingdom.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User extends Person {
    private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user")
    private GameLibrary library;

    public User(String name, Login login) {
        super(name, login);

    }
   
    public GameLibrary getLibrary() {
        return library;
    }

    public void setLibrary(GameLibrary library) {
        this.library = library;
    }
}
