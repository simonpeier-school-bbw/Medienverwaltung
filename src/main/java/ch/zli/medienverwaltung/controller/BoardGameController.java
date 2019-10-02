package ch.zli.medienverwaltung.controller;

import ch.zli.medienverwaltung.domain.BoardGame;
import ch.zli.medienverwaltung.service.BoardGameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/boardGames")
public class BoardGameController {
    private BoardGameService boardGameService;

    public BoardGameController(BoardGameService boardGameService) {
        this.boardGameService = boardGameService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BoardGame> getAllBoardGames() {
        return boardGameService.getAllBoardGames();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BoardGame addBoardGame(@Valid @RequestBody BoardGame boardGame) {
        return boardGameService.addBoardGame(boardGame);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBoardGame(@PathVariable Long id) {
        boardGameService.deleteBoardGameById(id);

    }
}
