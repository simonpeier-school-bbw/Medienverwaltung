package ch.zli.medienverwaltung.repository;

import ch.zli.medienverwaltung.domain.DVD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVDRepository extends JpaRepository<DVD, Long> {
}
