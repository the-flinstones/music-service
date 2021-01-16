package com.flinstone.musicservice.controller;

import com.flinstone.musicservice.entity.UserPlaylistsEntity;
import com.flinstone.musicservice.service.UserPlaylistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@RestController
public class UserPlaylistsController {
    @Autowired
    private UserPlaylistsService userPlaylistsService;

    //-----------------------------Create New Playlist---------------------------------------
    @PostMapping("/playlist")
    public UserPlaylistsEntity createPlaylist(@Valid @RequestBody UserPlaylistsEntity playlist) {

        return userPlaylistsService.createPlaylist(playlist);
    }

    //------------------------------Create All Playlist------------------------------------------
    @PostMapping("/playlists")
    List<UserPlaylistsEntity> createPlaylists(@RequestBody List<UserPlaylistsEntity> playlist){

        return userPlaylistsService.createPlaylists(playlist);
    }

    //-------------------------------Get Playlist By ID --------------------------------------------
    @GetMapping(value = "/playlist/{id}")
    public List<UserPlaylistsEntity> getPlaylistById(@PathVariable("id") String id) {
        return userPlaylistsService.getPlaylistsById(id);
    }

    //-------------------------------Get All Playlists--------------------------------------------
    @GetMapping(value = "/playlists")
    public List<UserPlaylistsEntity> getAllPlaylists() {

        return userPlaylistsService.getAllPlaylists();
    }

    //-------------------------------Update Playlist By ID ----------------------------------------
    @PutMapping(value = "/playlist/{id}")
    public UserPlaylistsEntity updatePlaylistById(@PathVariable("id") String id, @RequestBody UserPlaylistsEntity playlist) {

        return userPlaylistsService.updatePlaylistById(id, playlist);
    }

    //---------------------------------Delete Playlist By ID ---------------------------------------
    @DeleteMapping(value = "/playlist/{id}")
    public String deletePlaylistById(@PathVariable("id") String id) {

        userPlaylistsService.deletePlaylistById(id);
        return "Playlist with id " + id + " has been deleted!";
    }

    //-------------------------------Get all songs from playlist-----------------------------------
    @GetMapping(value = "/playlist-songs/{userId}/{playlistId}")
    public List<UserPlaylistsEntity> getAllSongsByPlaylistIdUserId(@PathVariable("userId") String userId, String playlistId) {
        return  userPlaylistsService.getAllSongsByPlaylistIdUserId(userId, playlistId);
    }
}
