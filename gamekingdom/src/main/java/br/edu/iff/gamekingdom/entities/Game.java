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
	@NotNull(message = "cant be null")
	@DecimalMin(value = "1", message = "enter some value to the game")
	@DecimalMax(value = "400", message = "more than this is a theft")
	@Column(name = "price")
	private Double price;
	
	@Nullable
	@ElementCollection
	private List<String> genres;
	
	@Nullable
	@ElementCollection
	private List<String> platforms;
	
	@Nullable
	@ElementCollection
	private Map<String, String> digitalStores;

    @ManyToOne
    @JoinColumn(name = "gamelib_id")
    private GameLibrary gameLibrary;

	public Game(String title, Double price) {
		this.title = title;
		this.price = price;
		this.genres = new ArrayList<>();
		this.platforms = new ArrayList<>();
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

	public Double getPrice() {
		return price;
	}

	public void setPrices(Double price) {
		this.price = price;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getPlatforms() {
		return platforms;
	}

	public void setPlatforms(List<String> platforms) {
		this.platforms = platforms;
	}

	public void addPlatform(String platform) {
		this.platforms.add(platform);
	}

	public void deletePlatform(String platform) {
		this.platforms.remove(platform);
	}

	public void addGenre(String genre) {
		this.genres.add(genre);
	}

	public void deleteGenre(String genre) {
		this.genres.remove(genre);
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
