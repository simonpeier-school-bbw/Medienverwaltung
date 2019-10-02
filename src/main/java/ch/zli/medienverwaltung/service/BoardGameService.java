package ch.zli.medienverwaltung.service;

import ch.zli.medienverwaltung.domain.BoardGame;
import ch.zli.medienverwaltung.repository.BoardGameRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class BoardGameService {
    private BoardGameRepository boardGameRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

    public BoardGame findBoardGameByName(String name) {
        String queryString = "SELECT bg FROM BoardGame as bg WHERE bg.name = :name";

        TypedQuery<BoardGame> query = entityManager.createQuery(queryString, BoardGame.class);
        query.setParameter("name", name);
        return (BoardGame) query.getSingleResult();
    }
}
