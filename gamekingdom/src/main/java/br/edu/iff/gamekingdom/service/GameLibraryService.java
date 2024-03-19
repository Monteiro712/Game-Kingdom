package br.edu.iff.gamekingdom.service;

import br.edu.iff.gamekingdom.entities.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.iff.gamekingdom.entities.GameLibrary;
import br.edu.iff.gamekingdom.entities.User;
import br.edu.iff.gamekingdom.repository.GameLibraryRepository;

@Service
public class GameLibraryService {

	@Autowired
	private GameLibraryRepository gameLibraryRepository;

	@Autowired
	private GameService gameService;

	@Autowired
	private UserService userService;

	public String addLibrary(Long userId) {
		User user = userService.findUserById(userId);
		if (user != null) {
			GameLibrary newGameLib = new GameLibrary();
			user.setLibrary(newGameLib);
			gameLibraryRepository.save(newGameLib);
			gameLibraryRepository.flush();
			return "Lista de desejos criada.";
		} else {
			return "Usuario não existe.";
		}
	}

	public String addGameToLibrary(Long libraryId, Long gameId) {
		GameLibrary gameLibrary = gameLibraryRepository.findLibraryById(libraryId);
		if (gameLibrary != null) {
			Game game = gameService.findGameById(gameId);
			if (game != null) {
				gameLibrary.addGame(game);
				gameLibraryRepository.save(gameLibrary);
				gameLibraryRepository.flush();
				return "Jogo adicionado a lista de desejos.";
			} else {
				return "O jogo não existe.";
			}
		} else {
			return "Lista desejos não existe.";
		}
	}
}
