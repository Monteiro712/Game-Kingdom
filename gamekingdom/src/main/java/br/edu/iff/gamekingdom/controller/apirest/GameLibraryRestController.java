package br.edu.iff.gamekingdom.controller.apirest;

import br.edu.iff.gamekingdom.entities.Game;
import br.edu.iff.gamekingdom.entities.GameLibrary;
import br.edu.iff.gamekingdom.service.GameLibraryService;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/game-library")
public class GameLibraryRestController {

    @Autowired
	private GameLibraryService gameLibraryService;

    @PostMapping("")
    public ResponseEntity<String> addLibrary(Long clienteId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameLibraryService.addLibrary(clienteId));
    }

    @PostMapping("/{id}/game/{gameId}")
    public ResponseEntity<String> addGameToLibrary(@PathVariable Long clienteId, @PathVariable Long gameId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gameLibraryService.addGameToLibrary(clienteId, gameId));
    }
}