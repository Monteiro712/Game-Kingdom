package br.edu.iff.gamekingdom.entities;

import java.io.Serializable;

import jakarta.persistence.*;
@Entity
public class Login implements Serializable {
    private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "password")
    private String password;
    @Column (name = "email")
    private String email;
    @OneToOne
    @JoinColumn(name = "fk_person")
    private Person person;
    public Login(String password, String email, Person person) {
        this.password = password;
        this.email = email;
        this.person = person;
    }
    public Login() {

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}