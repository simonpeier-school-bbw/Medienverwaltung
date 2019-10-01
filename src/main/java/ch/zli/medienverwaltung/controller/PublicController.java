package ch.zli.medienverwaltung.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping
    public String getMessage(UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
        return "Hello from public API controller";
    }
}