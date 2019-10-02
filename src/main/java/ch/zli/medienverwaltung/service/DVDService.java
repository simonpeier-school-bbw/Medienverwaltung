package ch.zli.medienverwaltung.service;

import ch.zli.medienverwaltung.domain.DVD;
import ch.zli.medienverwaltung.repository.DVDRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DVDService {
    private DVDRepository dvdRepository;

    public DVDService(DVDRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }

    public List<DVD> getAllDVDs() {
        return dvdRepository.findAll();
    }

    public Optional<DVD> getDVDById(long id) {
        return dvdRepository.findById(id);
    }

    public DVD addDVD(DVD dvd) {
        return dvdRepository.saveAndFlush(dvd);
    }

    public void deleteDVDById(long id) {
        if (dvdRepository.existsById(id)) {
            dvdRepository.deleteById(id);
        }
    }
}
