package com.pedrohenrique.workshopspirngmongodb.config;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedrohenrique.workshopspirngmongodb.domain.Post;
import com.pedrohenrique.workshopspirngmongodb.repository.PostRepository;

import com.pedrohenrique.workshopspirngmongodb.domain.User;
import com.pedrohenrique.workshopspirngmongodb.dto.AuthorDTO;
import com.pedrohenrique.workshopspirngmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Marie Brown", "marie@email.com");
        User u2 = new User(null, "John Doe", "john@email.com");
        User u3 = new User(null, "Bob Grey", "bob@email.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        Post p1 = new Post(null, sdf.parse("01/10/2018"), "Bom dia!", "Dia incrível aqui em cidade 1!!!", new AuthorDTO(u1));
        Post p2 = new Post(null, sdf.parse("28/10/2018"), "Partiu viagem!", "Vou viajar para São Paulo!!!", new AuthorDTO(u1));
        
        postRepository.saveAll(Arrays.asList(p1, p2));
        u1.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(u1);
    }
    
}
