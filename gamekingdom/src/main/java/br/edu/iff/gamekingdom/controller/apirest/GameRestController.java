package br.edu.iff.gamekingdom.controller.apirest;

import br.edu.iff.gamekingdom.entities.Game;

import br.edu.iff.gamekingdom.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/game")
public class GameRestController {

	@Autowired
	private GameService gameService;

	@PostMapping
	public ResponseEntity<Game> addGame(String title, Double price) {
		Game newGame = gameService.addGame(title, price);
		return ResponseEntity.status(HttpStatus.CREATED).body(newGame);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Game> updateGame(@PathVariable Long id, String title, Double price) {
		Game updatedGame = gameService.updateGame(id, title, price);
		return ResponseEntity.ok(updatedGame);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteGame(@PathVariable Long id) {
		gameService.deleteGame(id);
		return ResponseEntity.ok("Game deleted");
	}

	@GetMapping
	public ResponseEntity<List<Game>> listAllGames() {
		List<Game> games = gameService.listAllGames();
		return ResponseEntity.ok(games);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Game> findGameById(@PathVariable("id") Long id) {
		Game game = gameService.findGameById(id);
		return ResponseEntity.ok(game);
	}
}