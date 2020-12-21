package com.flinstone.musicservice.service;

import com.flinstone.musicservice.entity.CategoryEntity;
import com.flinstone.musicservice.entity.SongEntity;
import com.flinstone.musicservice.entity.UserPlaylistsEntity;
import com.flinstone.musicservice.repository.SongRepository;
import com.flinstone.musicservice.repository.UserPlaylistsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserPlaylistsService {
    final UserPlaylistsRepo userPlaylistsRepo;
    List<UserPlaylistsEntity> allUsers;

    public UserPlaylistsService(UserPlaylistsRepo userPlaylistsRepo) {
        this.userPlaylistsRepo = userPlaylistsRepo;
        this.allUsers = userPlaylistsRepo.findAll();
    }

    //----------------------------Create playlist-----------------------------------------------------
    public UserPlaylistsEntity createPlaylist(UserPlaylistsEntity playlist){

        return userPlaylistsRepo.save(playlist);
    }

    //----------------------------Create all playlists------------------------------------------------
    public List<UserPlaylistsEntity> createPlaylists(List<UserPlaylistsEntity> playlists){
        return userPlaylistsRepo.saveAll(playlists);
    }

    //----------------------------Get playlist by ID--------------------------------------------------------
    public UserPlaylistsEntity getPlaylistById(String id){

        return userPlaylistsRepo.findById(id).get();
    }

    //----------------------------Get all playlists----------------------------------------------------
    public List<UserPlaylistsEntity> getAllPlaylists(){

        return userPlaylistsRepo.findAll();
    }

    //------------------------------Update playlist By ID ------------------------------------------------
    public UserPlaylistsEntity updatePlaylistById(String id, UserPlaylistsEntity playlist) {

        /*Optional<UserPlaylistsEntity> optionalPlaylist = userPlaylistsRepo.findById(id);
        if (!optionalPlaylist.isPresent())
            throw new UserPlaylistsEntityNotFoundException("User Playlist Record with id " + id + " is not available");
        player.setPlayerId(id);*/
        playlist.setPlaylistId(id);
        return userPlaylistsRepo.save(playlist);
    }

    //-------------------------------Delete Playlist By ID ----------------------------------------------
    public void deletePlaylistById(String id) {

        /*Optional<UserPlaylistsEntity> optionalUser = userPlaylistsRepo.findById(id);
        if (!optionalUser.isPresent())
            throw new UserNotFoundException("User Record with id " + id + " is not available");*/
        userPlaylistsRepo.deleteById(id);
    }

    //-------------------------------Get all songs from playlist----------------------------------------------
    public List<UserPlaylistsEntity> getAllSongsByPlaylistIdUserId(String userId, String playlistId) {
        List<UserPlaylistsEntity> playlistSongs = new ArrayList<>();
        for (UserPlaylistsEntity userPlaylistsEntity:allUsers
        ) {
            if(userPlaylistsEntity.getUserId().equals(userId)) {
                if (userPlaylistsEntity.getPlaylistId().equals(playlistId)) {
                    playlistSongs.add(userPlaylistsEntity);
                }
            }
        }
        return playlistSongs;
    }
}
