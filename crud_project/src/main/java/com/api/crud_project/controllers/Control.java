package com.api.crud_project.controllers;

import com.api.crud_project.models.User;
import com.api.crud_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class Control {
    @Autowired
    private UserRepository userRepository;      /*injeção de dependência*/

    //ROTAS
    @GetMapping(value = "showAllUsers")
    @ResponseBody           /*Retorna todos os dados*/
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);   /*Lista de todos usuarios (Json)*/
    }

    @PostMapping(value = "save")     /*Mapeia URL*/
    @ResponseBody                    /*Descricao da Resposta*/
    public ResponseEntity<User> save(@RequestBody User user) {
        User createdUser = userRepository.save(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long userID) {
        userRepository.deleteById(userID);
        return new ResponseEntity<String>("User deleted sucessfully", HttpStatus.OK);
    }

    @GetMapping(value = "search")
    @ResponseBody
    public ResponseEntity<User> search(@RequestParam(name = "userID") Long userID) {
        User user = userRepository.findById(userID).get();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping(value = "searchByName")
    @ResponseBody
    public ResponseEntity<List<User>> searchByName(@RequestParam(name = "name") String name) {
        List<User> users = userRepository.searchByName(name.trim().toUpperCase());
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }

    @PutMapping(value = "update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody User user) {
        User updatedUser = userRepository.saveAndFlush(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
