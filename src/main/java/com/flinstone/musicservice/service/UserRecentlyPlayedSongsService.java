package com.flinstone.musicservice.service;

import com.flinstone.musicservice.entity.Recent;
import com.flinstone.musicservice.entity.SongEntity;
import com.flinstone.musicservice.repository.UserRecentlyPlayedSongsRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserRecentlyPlayedSongsService {

    final UserRecentlyPlayedSongsRepo repo;
    public UserRecentlyPlayedSongsService(UserRecentlyPlayedSongsRepo repo) {
        this.repo = repo;
    }
    public List<Recent> getAll(){
        return repo.findAll();
    }
    public Recent createUserRecentlyPlayedSongsList(Set<SongEntity> songs, String userId){
        Recent recent = new Recent();
        recent.setUserId(userId);
        recent.setRecentlyPlayedSongs(songs);
        return repo.save(recent);
    }

    public Optional<Recent> getById(String userId) {
        return repo.findByUserId(userId);
    }

//    public Optional<Recent> getById(String userId){
//        return repo.findByUserId(userId);
//    }
//    public Recent updateRecentlyPlayedList(String userId,List<String> songIds){
//        Recent recent = repo.findById(userId).get();
//        recent.setRecentlyPlayedId(songIds);
//        return recent;
//    }
}
