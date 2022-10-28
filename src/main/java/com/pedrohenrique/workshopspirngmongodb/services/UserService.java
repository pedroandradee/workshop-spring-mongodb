package com.pedrohenrique.workshopspirngmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrohenrique.workshopspirngmongodb.domain.User;
import com.pedrohenrique.workshopspirngmongodb.dto.UserDTO;
import com.pedrohenrique.workshopspirngmongodb.repository.UserRepository;
import com.pedrohenrique.workshopspirngmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    /*public User findById(String id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new ObjectNotFoundException("Usuário não encontrado! id: " + id);
        }
        return user;
    }*/

    public User store(User obj) {
        return userRepository.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
