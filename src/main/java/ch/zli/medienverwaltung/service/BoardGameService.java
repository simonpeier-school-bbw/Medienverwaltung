package ch.zli.medienverwaltung.service;

import ch.zli.medienverwaltung.domain.BoardGame;
import ch.zli.medienverwaltung.repository.BoardGameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardGameService {
    private BoardGameRepository boardGameRepository;

    public BoardGameService(BoardGameRepository boardGameRepository) {
        this.boardGameRepository = boardGameRepository;
    }

    public List<BoardGame> getAllBoardGames() {
        return boardGameRepository.findAll();
    }

    public Optional<BoardGame> getBoardGameById(long id) {
        return boardGameRepository.findById(id);
    }

    public BoardGame addBoardGame(BoardGame boardGame) {
        return boardGameRepository.saveAndFlush(boardGame);
    }

    public void deleteBoardGameById(long id) {
        if (boardGameRepository.existsById(id)) {
            boardGameRepository.deleteById(id);
        }
    }
}
