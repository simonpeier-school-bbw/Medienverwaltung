package ch.zli.medienverwaltung.service;

import ch.zli.medienverwaltung.domain.User;
import ch.zli.medienverwaltung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    public void deleteUserById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public User updateUser(User user, Long id) {
        User updatedUser;
        Optional<User> optionalUpdatedEntry = findUserById(id);

        if (optionalUpdatedEntry.isPresent()) {
            updatedUser = optionalUpdatedEntry.get();
            updatedUser.setUsername(user.getUsername());
        } else {
            updatedUser = user;
            updatedUser.setId(id);
        }
        updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(updatedUser);
    }
}
