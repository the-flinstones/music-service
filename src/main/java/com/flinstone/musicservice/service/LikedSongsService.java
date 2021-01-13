package com.flinstone.musicservice.service;

import com.flinstone.musicservice.entity.Liked;
import com.flinstone.musicservice.entity.Recent;
import com.flinstone.musicservice.entity.SongEntity;
import com.flinstone.musicservice.repository.LikedRepo;
import com.flinstone.musicservice.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LikedSongsService {

    final LikedRepo repo;

    public LikedSongsService(LikedRepo repo, SongRepository songRepository) {
        this.repo = repo;
        this.songRepository = songRepository;
    }

    final SongRepository songRepository;


    public List<Liked> getAll(){
        return repo.findAll();
    }
    public Liked createUserLikedSongsList(List<SongEntity> songs, String userId){
        if(!repo.existsById(userId))
        {
            Liked liked = new Liked();
            liked.setUserId(userId);
            liked.setLikedSongs(songs);
            return repo.save(liked);
        }
        else {
           Liked likedByUser =  repo.findByUserId(userId).get();
            for (SongEntity song: songs
                 ) {
                likedByUser.getLikedSongs().add(song);
            }
            return repo.save(likedByUser);
        }

    }
    //add to liked songs individual songs
    public Liked addToLikedList(SongEntity song, String userId){
        if(!repo.existsById(userId))
        {
            Liked liked = new Liked();
            liked.setUserId(userId);
            List<SongEntity> temp = new ArrayList<>();
            temp.add(song);
            liked.setLikedSongs(temp);
            return repo.save(liked);
        }
        else {
            Liked liked = repo.findByUserId(userId).get();
            liked.getLikedSongs().add(song);
            return repo.save(liked);
        }

    }

    public Optional<Liked> getById(String userId) {
        return repo.findByUserId(userId);
    }
    public boolean isSongLiked(String userId,String songId){
        List<SongEntity> likedSongsByUser = repo.findByUserId(userId).get().getLikedSongs();
        try{
            SongEntity songEntity = songRepository.findById(songId).get();
            for(SongEntity song:likedSongsByUser){
                if(song.getId().equals(songEntity.getId()))
                return true;
            }
        }catch(Exception e){
            System.out.println("song does not exit");
            return false;
        }

       return false;

    }
}
