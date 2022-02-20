package com.domenico.basicusermanagement.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    ResponseEntity<List<User>> displayAllEntries() {
        List<User> Users = userRepository.findAll();
        if (Users.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            return new ResponseEntity<>(Users, HttpStatus.OK);
        }
    }

    @PostMapping
    ResponseEntity<User> createUserEntry(@RequestBody User newUser) {
        blankStringsToNull(newUser);
        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<User> updateUserEntry(@PathVariable int id, @RequestBody User updateToUser) {
        if (userRepository.existsById(id)) {
            blankStringsToNull(updateToUser);
            Optional<User> existingUser = userRepository.findById(id);
            existingUser.get().setFirstName(updateToUser.getFirstName());
            existingUser.get().setMiddleName(updateToUser.getMiddleName());
            existingUser.get().setLastName(updateToUser.getLastName());
            existingUser.get().setEmail(updateToUser.getEmail());
            existingUser.get().setDateOfBirth(updateToUser.getDateOfBirth());
            userRepository.save(existingUser.get());
            return new ResponseEntity<>(existingUser.get(), HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteUserEntry(@PathVariable int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private void blankStringsToNull(User user) {
        if (user.getFirstName() != null && user.getFirstName().isBlank())
            user.setFirstName(null);
        if (user.getMiddleName() != null && user.getMiddleName().isBlank())
            user.setMiddleName(null);
        if (user.getLastName() != null && user.getLastName().isBlank())
            user.setLastName(null);
        if (user.getEmail() != null && user.getEmail().isBlank())
            user.setEmail(null);
    }

}
