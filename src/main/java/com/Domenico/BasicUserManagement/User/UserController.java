package com.Domenico.BasicUserManagement.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping ("/dbinit")
    void databaseInitialization ()	{
        User Marco = new User("Marco", "", "Toscano", "marco.toscano@outlook.com",
                LocalDate.of(2010, Month.APRIL, 4));
        User Donato = new User("Donato", "", "Rossi", "donato.rossi@gmail.com",
                LocalDate.of(1979, Month.DECEMBER, 9));
        User Roberto = new User("Roberto", "Nicola", "Bianchi", "roberto.bianchi@gmail.com",
                LocalDate.of(1994, Month.AUGUST, 24));

        ArrayList<User> initialEntries = new ArrayList<>();
        initialEntries.add(Marco);
        initialEntries.add(Donato);
        initialEntries.add(Roberto);
        userRepository.saveAll(initialEntries);
    }

    @GetMapping
    ResponseEntity<List<User>> displayAllEntries() {
        try {
            List<User> Users = userRepository.findAll();
            if (Users.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            else {
                return new ResponseEntity<>(Users, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
