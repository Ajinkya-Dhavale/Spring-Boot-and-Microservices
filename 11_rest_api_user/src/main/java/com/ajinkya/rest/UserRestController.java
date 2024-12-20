package com.ajinkya.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajinkya.Services.UserService;
import com.ajinkya.entity.UserEntity;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class UserRestController {

    @Autowired
    public UserService service;

    // GET request to retrieve all users
    @GetMapping(value = "/user", produces = "application/json")
    public ResponseEntity<List<UserEntity>> getUsers() {
        List<UserEntity> list = service.getUsers();
        return new ResponseEntity<>(list, HttpStatus.OK); // 200 OK for successful retrieval
    }


    // POST request to save a user
    @PostMapping(value = "/user", produces = "text/plain", consumes = "application/json")
    public ResponseEntity<String> saveUser(@RequestBody UserEntity user) {
        if (service.saveUser(user)) {
            return new ResponseEntity<>("User Inserted..", HttpStatus.CREATED); // 201 Created for successful insert
        }
        return new ResponseEntity<>("User Not Inserted..", HttpStatus.BAD_REQUEST); // 400 Bad Request for failure
    }

    // DELETE request to remove a user by ID
    @DeleteMapping(value = "/delete_user/{id}", produces = "text/plain")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        if (service.deleteUser(id)) {
            return new ResponseEntity<>("User Deleted..", HttpStatus.NO_CONTENT); // 204 No Content for successful delete
        }
        return new ResponseEntity<>("User Not Found..", HttpStatus.NOT_FOUND); // 404 Not Found if the user doesn't exist
    }
    
    @PutMapping("/update_user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
        if (service.updateUser(id, user)) {
            return new ResponseEntity<>("User Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
    }
    
    
}

