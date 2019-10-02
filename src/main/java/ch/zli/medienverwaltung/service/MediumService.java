package ch.zli.medienverwaltung.service;

import ch.zli.medienverwaltung.domain.Medium;
import ch.zli.medienverwaltung.repository.MediumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediumService {
    private MediumRepository mediumRepository;

    public MediumService(MediumRepository mediumRepository) {
        this.mediumRepository = mediumRepository;
    }

    public List<Medium> getAllMediums() {
        return mediumRepository.findAll();
    }

    public Optional<Medium> getMediumById(long id) {
        return mediumRepository.findById(id);
    }

    public Medium addMedium(Medium medium) {
        return mediumRepository.saveAndFlush(medium);
    }

    public void deleteMediumById(long id) {
        if (mediumRepository.existsById(id)) {
            mediumRepository.deleteById(id);
        }
    }
}
