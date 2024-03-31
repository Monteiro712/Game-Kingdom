package br.edu.iff.gamekingdom.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class GameLibrary implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @OneToMany(mappedBy = "gameLibrary", cascade = CascadeType.ALL)
    private List<Game> games;

	public GameLibrary() {

	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public List<Game> getGames() {
		return games;
	}

	public void addGame(Game game) {
		this.games.add(game);
	}

	public void deleteGame(Game game) {
		this.games.remove(game);
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
}
