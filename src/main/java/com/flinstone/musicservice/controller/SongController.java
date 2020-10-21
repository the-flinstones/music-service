package com.flinstone.musicservice.controller;

import com.flinstone.musicservice.entity.SongEntity;
import com.flinstone.musicservice.service.SongService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1")
@RestController
public class SongController {

    SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    //getAllSongs
    @GetMapping("/songs")
    List<SongEntity> getAll(){
        return songService.getAll();
    }

    //getSongById
    @GetMapping("/songs/{id}")
    SongEntity getById(@PathVariable("id") String id){
        return songService.getById(id);
    }

    //getSongByArtist
    @GetMapping("/songs/artist/{artist}")
    List<SongEntity> getSongsByArtist(@PathVariable("artist") String artist){
        return songService.getByArtist(artist);
    }

    //getSongByAlbum
    @GetMapping("/songs/album/{album}")
    List<SongEntity> getSongByAlbum(@PathVariable("album") String album){
        return songService.getByAlbum(album);
    }

    //getSongByGenre
    @GetMapping("/songs/genre/{genre}")
    List<SongEntity> getSongByGenre(@PathVariable("genre") String genre){
        return songService.getByGenre(genre);
    }
    //getSongByLanguage
    @GetMapping("/songs/lang/{language}")
    List<SongEntity> getSongByLanguage(@PathVariable("language") String language){
        return songService.getByLanguage(language);
    }

    //deleteById
    @DeleteMapping("/songs/{id}")
    void deleteById(@PathVariable("id") String id){
         songService.deleteById(id);
    }

    //createSong
    @PostMapping("/songs")
    SongEntity createSong(@RequestBody SongEntity songEntity){
        return songService.createSong(songEntity);
    }



}
