package com.domenico.basicusermanagement;

import com.domenico.basicusermanagement.user.User;
import com.domenico.basicusermanagement.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;


@Component
public class DatabaseInitialization implements CommandLineRunner {
    private final UserRepository userRepository;

    public DatabaseInitialization(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        User Marco = new User("Marco", null, "Toscano", "marco.toscano@outlook.com",
                LocalDate.of(2010, Month.APRIL, 4));
        User Donato = new User("Donato", null, "Rossi", "donato.rossi@gmail.com",
                LocalDate.of(1979, Month.DECEMBER, 9));
        User Roberto = new User("Roberto", "Nicola", "Bianchi", "roberto.bianchi@gmail.com",
                LocalDate.of(1994, Month.AUGUST, 24));

        ArrayList<User> initialEntries = new ArrayList<>();
        initialEntries.add(Marco);
        initialEntries.add(Donato);
        initialEntries.add(Roberto);
        userRepository.saveAll(initialEntries);
    }
}
