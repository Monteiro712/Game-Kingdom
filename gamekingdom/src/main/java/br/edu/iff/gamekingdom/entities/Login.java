package br.edu.iff.gamekingdom.entities;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "cant be null")
	@Size(min = 6, max = 60, message = "enter with your password")
	@Column(name = "password")
	private String password;
	@NotNull(message = "cant be null")
	@Size(min = 30, max = 60, message = "enter with your email address")
	@Column(name = "email")
	private String email;
	
	public Login(String password, String email) {
		this.password = password;
		this.email = email;
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
}