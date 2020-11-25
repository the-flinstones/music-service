package com.flinstone.musicservice.service;

import com.flinstone.musicservice.entity.CategoryEntity;
import com.flinstone.musicservice.repository.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryService {
    final CategoryRepo categoryRepo;

    //create
    public CategoryEntity create(CategoryEntity category){
        return categoryRepo.save(category);
    }
    //saveAll
    public List<CategoryEntity> createAll(List<CategoryEntity> categories){
        return categoryRepo.saveAll(categories);
    }
    //getAll
    public List<CategoryEntity> getAll(){
        return categoryRepo.findAll();
    }
    //findById
    public Optional<CategoryEntity> findByCategory(String id){
        return categoryRepo.findByCategoryId(id);
    }
    //delete
    public void deleteBYId(String id){
         categoryRepo.deleteById(id);
    }


}
