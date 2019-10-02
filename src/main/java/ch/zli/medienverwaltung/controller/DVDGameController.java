package ch.zli.medienverwaltung.controller;

import ch.zli.medienverwaltung.domain.DVD;
import ch.zli.medienverwaltung.service.DVDService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dvds")
public class DVDGameController {
    private DVDService dvdService;

    public DVDGameController(DVDService dvdService) {
        this.dvdService = dvdService;
    }

    // Holt alle DVD's aus der DB
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DVD> getAllDVDs() {
        return dvdService.getAllDVDs();
    }

    // Fügt der DB eine neue DVD hinzu
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DVD addDVD(@Valid @RequestBody DVD dvd) {
        return dvdService.addDVD(dvd);
    }

    // Löscht eine DVD aus der DB
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDVD(@PathVariable Long id) {
        dvdService.deleteDVDById(id);

    }
}
