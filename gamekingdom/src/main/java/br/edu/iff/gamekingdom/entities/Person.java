package br.edu.iff.gamekingdom.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@MappedSuperclass
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "cant be null")
    @Size(min = 3, max = 60, message = "enter with your name")
    @Column (name = "name")
    private String name;

    @NotNull(message = "cant be null")
    @Size(min = 1, max = 60, message = "enter with your login")
	@ManyToOne()
	@JoinColumn(name = "person_fk")
	private Login login;

    public Person(String name, Login login) {
        this.name = name;
        this.login = login;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
