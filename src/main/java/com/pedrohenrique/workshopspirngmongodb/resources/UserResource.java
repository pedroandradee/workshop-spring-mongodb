package com.pedrohenrique.workshopspirngmongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pedrohenrique.workshopspirngmongodb.domain.User;
import com.pedrohenrique.workshopspirngmongodb.dto.UserDTO;
import com.pedrohenrique.workshopspirngmongodb.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices userServices;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userServices.findAll();
        List<UserDTO> listDTO = list.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

}
