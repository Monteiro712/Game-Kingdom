package br.edu.iff.gamekingdom.entities;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "cant be null")
	@Size(min = 1, max = 60, message = "enter with the game name")
	@Column(name = "title")
	private String title;
	
	@NotNull(message = "O preço não pode ser nulo")
	@DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que 0")
	@DecimalMax(value = "9999.99", message = "O preço não pode ser maior que 9999.99")
	@Column(name = "price")
	private double price;
	
	@Nullable
	@ElementCollection
	private Map<String, String> digitalStores;

    @ManyToOne
    @JoinColumn(name = "gamelib_id")
    private GameLibrary gameLibrary;

	public Game(String title, double price) {
		this.title = title;
		this.price = price;
		this.digitalStores = new HashMap();
	}

	public Game() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void addDigitalStore(String storeName, String storeUrl) {
		this.digitalStores.put(storeName, storeUrl);
	}

	public void deleteDigitalStore(String storeName) {
		this.digitalStores.remove(storeName);
	}

	public void setDigitalStores(Map<String, String> digitalStores) {
		this.digitalStores = digitalStores;
	}

	public GameLibrary getGameLibrary() {
		return gameLibrary;
	}

	public void setGameLibrary(GameLibrary gameLibrary) {
		this.gameLibrary = gameLibrary;
	}
}
