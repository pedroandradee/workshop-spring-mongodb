package com.pedrohenrique.workshopspirngmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedrohenrique.workshopspirngmongodb.domain.User;
import com.pedrohenrique.workshopspirngmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        userRepository.deleteAll();

        User u1 = new User(null, "Marie Brown", "marie@email.com");
        User u2 = new User(null, "John Doe", "john@email.com");
        User u3 = new User(null, "Bob Grey", "bob@email.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

    }
    
}
