package ch.zli.medienverwaltung.controller;

import ch.zli.medienverwaltung.domain.User;
import ch.zli.medienverwaltung.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String getAllUsers(Model model) {
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("user", new User());
        return "users";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@Valid User user, Model model) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@Valid @RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user, id);
    }
}
