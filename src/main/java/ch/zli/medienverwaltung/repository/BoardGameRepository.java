package ch.zli.medienverwaltung.repository;

import ch.zli.medienverwaltung.domain.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, Long> {
}
