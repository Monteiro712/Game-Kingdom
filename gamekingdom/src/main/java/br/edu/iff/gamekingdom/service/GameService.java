package br.edu.iff.gamekingdom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import br.edu.iff.gamekingdom.entities.Game;
import br.edu.iff.gamekingdom.repository.GamesRepository;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GamesRepository gamesRepository;

    public Game addGame(String title, Double price) {
        Game newGame = new Game(title, price);
        return gamesRepository.save(newGame);
    }

    public Game updateGame(Long id, String title, Double price) {
        Game existingGame = gamesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found"));
        existingGame.setTitle(title);
        existingGame.setPrice(price);

        return gamesRepository.save(existingGame);
    }

    public void deleteGame(Long id) {

        gamesRepository.deleteById(id);
    }

    public List<Game> listAllGames() {

        return gamesRepository.findAll();
    }

    public Game findGameById(Long id) {

        return gamesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found with id: " + id));
    }

    public String addStore(Long gameId, String storeName, String storeUrl){
        Game game = findGameById(gameId);
        if (game != null) {
            game.addDigitalStore(storeName, storeUrl);
            gamesRepository.save(game);
            return "Loja adicionada ao jogo.";
        }
        return "O jogo não existe.";
    }

    public String deleteStore(Long gameId, String storeName){
        Game game = findGameById(gameId);
        if (game != null) {
            game.deleteDigitalStore(storeName);
            gamesRepository.delete(game);
            return "Loja deletado do jogo.";
        }
        return "O jogo não existe.";
    }

}
