package ch.zli.medienverwaltung.repository;

import ch.zli.medienverwaltung.domain.Medium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediumRepository extends JpaRepository<Medium, Long> {
}
