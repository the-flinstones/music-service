package com.flinstone.musicservice.service;

import com.flinstone.musicservice.entity.CategoryEntity;
import com.flinstone.musicservice.entity.SongEntity;
import com.flinstone.musicservice.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class SongService {
    SongRepository songRepository;
    List<SongEntity> allSongs;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
        this.allSongs = songRepository.findAll();
    }

    //getAll
    public List<SongEntity> getAll(){
        return songRepository.findAll();
    }
    //saveAll
    public List<SongEntity> createAll(List<SongEntity> songs){
        return songRepository.saveAll(songs);
    }
    //getById
    public SongEntity getById(String id){
        return songRepository.findById(id).get();
    }
    //deleteById
    public void deleteById(String id){
        songRepository.deleteById(id);
    }
    //creteSong
    public SongEntity createSong(SongEntity songEntity){
        String songURL = songEntity.getSongUrl();
        String newURL="http://docs.google.com/uc?export=open&id=";

      songURL=  songURL.replace("https://drive.google.com/file/d/","");

      songURL=  songURL.replace("/view?usp=sharing","");

         newURL = newURL.concat(songURL);
        songEntity.setSongUrl(newURL);

        return   songRepository.save(songEntity);
    }


    //getByAlbum
    public List<SongEntity> getByAlbum(String album){
        List<SongEntity> albumSongs = new ArrayList<>();


        for (SongEntity songEntity:allSongs
        ) {
            if(songEntity.getAlbum().equals(album))
                albumSongs.add(songEntity);
        }
        return albumSongs;
    }
    //getByActor
    public List<SongEntity> getByActor(String actor){
        List<SongEntity> actorSongs = new ArrayList<>();


        for (SongEntity songEntity:allSongs
        ) {
            if(songEntity.getActor().equals(actor))
                actorSongs.add(songEntity);
        }
        return actorSongs;
    }

    //getByArtist
    public List<SongEntity> getByArtist(String artist){
        List<SongEntity> artistSongs = new ArrayList<>();


        for (SongEntity song:allSongs
        ) {
            if(song.getArtist().equals(artist))
                artistSongs.add(song);
        }
        return artistSongs;
    }

    //getByGenre
    public List<SongEntity> getByGenre(String genre){
        List<SongEntity> genreSongs = new ArrayList<>();


        for (SongEntity song:allSongs
        ) {
            if(song.getMood().equals(genre))
                genreSongs.add(song);
        }
        return genreSongs;
    }

    //getByLang
    public List<SongEntity> getByLanguage(String language){
        List<SongEntity> languageSongs = new ArrayList<>();


        for (SongEntity song:allSongs
        ) {
            if(song.getLanguage().equals(language))
                languageSongs.add(song);
        }
        return languageSongs;
    }




}
