package com.flinstone.musicservice.controller;

import com.flinstone.musicservice.entity.Liked;
import com.flinstone.musicservice.entity.SongEntity;
import com.flinstone.musicservice.service.LikedSongsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
public class LikedSongsController {
    public LikedSongsController(LikedSongsService service) {
        this.service = service;
    }
    final LikedSongsService service;

    @GetMapping("/user/liked")
    List<Liked> getAll(){
        return service.getAll();
    }

    @PostMapping("/user/liked/{userId}")
    Liked createLiked(@RequestBody List<SongEntity> songs, @PathVariable String userId){
        return service.createUserLikedSongsList(songs,userId);
    }
    @PostMapping("/user/liked/song/{userId}")
    Liked addToLiked(@RequestBody SongEntity song, @PathVariable String userId){
        return service.addToLikedList(song,userId);
    }
    @GetMapping("/user/liked/{userId}")
    Optional<Liked> getByIUserIdd(@PathVariable String userId){
        return service.getById(userId);
    }
    @GetMapping("/user/liked/{userId}/{songId}")
    Boolean isSongLiked(@PathVariable String userId,@PathVariable String songId){
        return service.isSongLiked(userId,songId);
    }
}
