package com.flinstone.musicservice.service;

import com.flinstone.musicservice.entity.SubCategoryEntity;
import com.flinstone.musicservice.repository.SubCategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SubCategoryService {
    final SubCategoryRepo subCategoryRepo;

    //create
    public SubCategoryEntity create(SubCategoryEntity subcategory){
        return subCategoryRepo.save(subcategory);
    }
    //saveAll
    public List<SubCategoryEntity> saveAll(List<SubCategoryEntity> subcategory){
        return subCategoryRepo.saveAll(subcategory);
    }
    //getAll
    public List<SubCategoryEntity> getAll(){
        return subCategoryRepo.findAll();
    }
    //findSubCategoriesById
    public List<SubCategoryEntity> findAllByCategoryId(String category){
        List<SubCategoryEntity> subcategories = subCategoryRepo.findByCategoryId(category);
        return subcategories;

    }
    //findSubCategory
    public SubCategoryEntity findBySubCategoryId(String category,String subcategory){
        List<SubCategoryEntity> subcategories =  findAllByCategoryId(category);
        for (SubCategoryEntity subcat:subcategories
             ) {
            if(subcat.getSubCategoryId().equals(subcategory))
            return subcat;
        }
        return null;
    }

}
