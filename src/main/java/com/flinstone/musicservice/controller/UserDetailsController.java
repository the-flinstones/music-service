//package com.flinstone.musicservice.controller;
//
//import com.flinstone.musicservice.entity.SongEntity;
//import com.flinstone.musicservice.entity.UserDetailsEntity;
//import com.flinstone.musicservice.entity.UserPlaylistsEntity;
//import com.flinstone.musicservice.repository.UserDetailsRepo;
//import com.flinstone.musicservice.service.UserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RequestMapping("/api/v1")
//@RestController
//public class UserDetailsController {
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    //-----------------------------Create New User---------------------------------------
//    @PostMapping("/user")
//    public UserDetailsEntity createUser(@Valid @RequestBody UserDetailsEntity user) {
//
//        return userDetailsService.createUser(user);
//    }
//
//    //------------------------------Create All User------------------------------------------
//    @PostMapping("/users")
//    List<UserDetailsEntity> createUsers(@RequestBody List<UserDetailsEntity> user){
//
//        return userDetailsService.createUsers(user);
//    }
//
//    //-------------------------------Get All Users--------------------------------------------
//    @GetMapping(value = "/users")
//    public List<UserDetailsEntity> getAllUsers() {
//
//        return userDetailsService.getAllUsers();
//    }
//
//    //-------------------------------Get User by email--------------------------------------------
//    @GetMapping(value = "/user-email/{email}")
//    public UserDetailsEntity getUserByEmail(@PathVariable("email") String email) {
//
//        return userDetailsService.getUserByEmail(email);
//    }
//
//    //-------------------------------Update User By Email----------------------------------------
//    @PutMapping(value = "/user/{email}")
//    public UserDetailsEntity updateUserByEmail(@PathVariable("email") String email, @RequestBody UserDetailsEntity user) {
//
//        return userDetailsService.updateUserByEmail(email, user);
//    }
//
//    //---------------------------------Delete User By Email---------------------------------------
//    @DeleteMapping(value = "/user/{email}")
//    public String deleteUserById(@PathVariable("email") String email) {
//
//        userDetailsService.deleteUserByEmail(email);
//        return "User with email " + email + " has been deleted!";
//    }
//}
