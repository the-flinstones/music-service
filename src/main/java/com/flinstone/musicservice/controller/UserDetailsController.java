package com.flinstone.musicservice.controller;

import com.flinstone.musicservice.entity.SongEntity;
import com.flinstone.musicservice.entity.UserDetailsEntity;
import com.flinstone.musicservice.entity.UserPlaylistsEntity;
import com.flinstone.musicservice.repository.UserDetailsRepo;
import com.flinstone.musicservice.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@RestController
public class UserDetailsController {
    @Autowired
    private UserDetailsService userDetailsService;

    //-----------------------------Create New User---------------------------------------
    @PostMapping("/user")
    public UserDetailsEntity createUser(@Valid @RequestBody UserDetailsEntity user) {

        return userDetailsService.createUser(user);
    }

    //------------------------------Create All User------------------------------------------
    @PostMapping("/users")
    List<UserDetailsEntity> createUsers(@RequestBody List<UserDetailsEntity> user){

        return userDetailsService.createUsers(user);
    }

    //-------------------------------Get User By ID --------------------------------------------
    @GetMapping(value = "/user/{id}")
    public UserDetailsEntity getUserById(@PathVariable("id") String id) {

        return userDetailsService.getUserById(id);
    }

    //-------------------------------Get All Users--------------------------------------------
    @GetMapping(value = "/users")
    public List<UserDetailsEntity> getAllUsers() {

        return userDetailsService.getAllUsers();
    }

    //-------------------------------Update User By ID ----------------------------------------
    @PutMapping(value = "/user/{id}")
    public UserDetailsEntity updateUserById(@PathVariable("id") String id, @RequestBody UserDetailsEntity user) {

        return userDetailsService.updateUserById(id, user);
    }

    //---------------------------------Delete User By ID ---------------------------------------
    @DeleteMapping(value = "/user/{id}")
    public String deleteUserById(@PathVariable("id") String id) {

        userDetailsService.deleteUserById(id);
        return "User with id " + id + " has been deleted!";
    }
}
