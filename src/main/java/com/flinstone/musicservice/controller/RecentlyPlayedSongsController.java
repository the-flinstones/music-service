package com.flinstone.musicservice.controller;

import com.flinstone.musicservice.entity.CategoryEntity;
import com.flinstone.musicservice.entity.Recent;
import com.flinstone.musicservice.entity.SongEntity;
import com.flinstone.musicservice.service.UserRecentlyPlayedSongsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@RestController
public class RecentlyPlayedSongsController {


  final UserRecentlyPlayedSongsService service;
    public RecentlyPlayedSongsController(UserRecentlyPlayedSongsService service) {
        this.service = service;
    }



    @GetMapping("/user/recent")
    List<Recent> getAll(){
        return service.getAll();
    }

    @PostMapping("/user/recent/{userId}")
    Recent createRecent(@RequestBody Set<SongEntity> songs, @PathVariable String userId){
        return service.createUserRecentlyPlayedSongsList(songs,userId);
    }
    @GetMapping("/user/recent/{userId}")
    Optional<Recent> getByIUserIdd(@PathVariable String userId){
        return service.getById(userId);
    }

//    @PutMapping("/user/recent/{userId}")
//    void updateRecentlyPlayedList(@PathVariable("userId") String userId,@RequestBody List<String> songs){
//        service.updateRecentlyPlayedList(userId,songs);
//    }

}
