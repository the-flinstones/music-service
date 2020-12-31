package com.flinstone.musicservice.service;

import com.flinstone.musicservice.entity.UserDetailsEntity;
import com.flinstone.musicservice.entity.UserPlaylistsEntity;
import com.flinstone.musicservice.repository.UserDetailsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UserDetailsService {
    final UserDetailsRepo userDetailsRepo;

    //----------------------------Create user-----------------------------------------------------
    public UserDetailsEntity createUser(UserDetailsEntity user){

        return userDetailsRepo.save(user);
    }

    //----------------------------Create users------------------------------------------------
    public List<UserDetailsEntity> createUsers(List<UserDetailsEntity> users){
        return userDetailsRepo.saveAll(users);
    }

    //----------------------------Get by ID--------------------------------------------------------
    public UserDetailsEntity getUserById(String id){

        return userDetailsRepo.findById(id).get();
    }

    //----------------------------Get all users--------------------------------------------------------
    public List<UserDetailsEntity> getAllUsers(){

        return userDetailsRepo.findAll();
    }

    //------------------------------Update User By ID ------------------------------------------------
    public UserDetailsEntity updateUserById(String id, UserDetailsEntity user) {

        /*Optional<UserDetailsEntity> optionalUser = userDetailsRepo.findById(id);
        if (!optionalUserDetailsEntity.isPresent())
            throw new UserDetailsEntityNotFoundException("UserDetailsEntity Record with id " + id + " is not available");
        player.setPlayerId(id);*/
        user.setId(id);
        return userDetailsRepo.save(user);
    }

    //-------------------------------Delete User By ID ----------------------------------------------
    public void deleteUserById(String id) {

        /*Optional<UserDetailsEntity> optionalUser = userDetailsRepo.findById(id);
        if (!optionalUser.isPresent())
            throw new UserNotFoundException("User Record with id " + id + " is not available");*/
        userDetailsRepo.deleteById(id);
    }
}
