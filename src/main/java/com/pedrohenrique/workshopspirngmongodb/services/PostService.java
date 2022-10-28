package com.pedrohenrique.workshopspirngmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrohenrique.workshopspirngmongodb.domain.Post;
import com.pedrohenrique.workshopspirngmongodb.repository.PostRepository;
import com.pedrohenrique.workshopspirngmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }
}
