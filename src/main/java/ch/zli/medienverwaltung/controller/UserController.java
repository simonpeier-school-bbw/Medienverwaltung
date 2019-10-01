package ch.zli.medienverwaltung.controller;

import ch.zli.medienverwaltung.domain.User;
import ch.zli.medienverwaltung.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createEntry(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEntry(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateEntry(@Valid @RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user, id);
    }
}
