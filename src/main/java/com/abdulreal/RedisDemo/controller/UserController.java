package com.abdulreal.RedisDemo.controller;

import com.abdulreal.RedisDemo.config.TestConnection;
import com.abdulreal.RedisDemo.model.User;
import com.abdulreal.RedisDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TestConnection testConnection;

    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user){
//        System.out.println("Testing if Redis is connected: " + testConnection.isRedisConnected());

        boolean result = userService.saveUser(user);

        if(result)
            return ResponseEntity.ok("User Created Successfully!!");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> fetchAllUser(){
        List<User> users = userService.fetchAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> fetchUserById(@PathVariable(value = "id") Long id){
        User user = userService.fetchUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id){
        boolean result = userService.deleteUser(id);

        if(result)
            return ResponseEntity.ok("User Deleted Successfully");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
