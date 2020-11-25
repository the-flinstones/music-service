package com.flinstone.musicservice.controller;

import com.flinstone.musicservice.entity.CategoryEntity;
import com.flinstone.musicservice.entity.SongEntity;
import com.flinstone.musicservice.entity.SubCategoryEntity;
import com.flinstone.musicservice.service.CategoryService;
import com.flinstone.musicservice.service.SongService;
import com.flinstone.musicservice.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
@RestController
public class SongController {

    final SongService songService;
    final CategoryService categoryService;
    final SubCategoryService subCategoryService;

    public SongController(SongService songService, CategoryService categoryService, SubCategoryService subCategoryService) {
        this.songService = songService;
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
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

    //CATEGORIES
    //getCategories
    @GetMapping("/category")
    List<CategoryEntity> getAllCategories(){
        return categoryService.getAll();
    }
    //getCategoryById
    @GetMapping("/category/{id}")
    Optional<CategoryEntity> getCategoryById(@PathVariable("id") String id){
        return categoryService.findByCategory(id);
    }
    //create category
    @PostMapping("/category")
    CategoryEntity createCategory(@RequestBody CategoryEntity category){
        return categoryService.create(category);
    }
    //delete category
    @DeleteMapping("/category/{id}")
    void deleteCategory(@PathVariable("id") String id){
        categoryService.deleteBYId(id);
    }

    //SUB CATEGORIES
    //getSubCategories
    @GetMapping("/subcategory")
    List<SubCategoryEntity> getAllSubCategories(){
        return subCategoryService.getAll();
    }
    //getSubCategoryById
    @GetMapping("/subcategory/{category}")
    List<SubCategoryEntity> findAllByCategoryId(@PathVariable("category") String category){
        return subCategoryService.findAllByCategoryId(category);
    }
    @GetMapping("/subcategory/{category}/{subcategory}")
    SubCategoryEntity findByCategoryIdSubcategoryId(@PathVariable("category") String category,@PathVariable("subcategory") String subcategory){
        return subCategoryService.findBySubCategoryId(category,subcategory);
    }
    //create subcategory
    @PostMapping("/subcategory")
    SubCategoryEntity createSubCategory(@RequestBody SubCategoryEntity subcategory){
        return subCategoryService.create(subcategory);
    }
    //create subcategories
    @PostMapping("/subcategories")
    List<SubCategoryEntity> createSubCategories(@RequestBody List<SubCategoryEntity> subcategory){
        return subCategoryService.saveAll(subcategory);
    }
//    //delete subcategory
//    @DeleteMapping("/subcategory/{id}")
//    void deleteSubCategory(@PathVariable("id") String id){
//        subCategoryService.deleteBYId(id);
//    }


}
