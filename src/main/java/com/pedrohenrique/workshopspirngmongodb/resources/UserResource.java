package com.pedrohenrique.workshopspirngmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pedrohenrique.workshopspirngmongodb.domain.User;
import com.pedrohenrique.workshopspirngmongodb.dto.UserDTO;
import com.pedrohenrique.workshopspirngmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userServices;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userServices.findAll();
        List<UserDTO> listDTO = list.stream().map(u -> new UserDTO(u)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    /*@RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = userServices.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj));
    }*/

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> store(@RequestBody UserDTO objDto) {
        User obj = userServices.fromDTO(objDto);
        obj = userServices.store(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
