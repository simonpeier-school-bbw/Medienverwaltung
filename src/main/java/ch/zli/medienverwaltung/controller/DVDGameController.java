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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DVD> getAllDVDs() {
        return dvdService.getAllDVDs();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DVD addDVD(@Valid @RequestBody DVD dvd) {
        return dvdService.addDVD(dvd);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDVD(@PathVariable Long id) {
        dvdService.deleteDVDById(id);

    }
}
