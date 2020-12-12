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
    public SubCategoryEntity findByCategoryIdSubCategoryId(String category,String subcategory){
        List<SubCategoryEntity> subcategories =  findAllByCategoryId(category);
        for (SubCategoryEntity subcat:subcategories
        ) {
            if(subcat.getSubCategoryId().equals(subcategory))
                return subcat;
        }
        return null;
    }
    //update
    public void updateByCategoryIdSubCategoryId(String categoryId,String subcategoryId,SubCategoryEntity newSubcategory){
//        List<SubCategoryEntity> subcategories =  findAllByCategoryId(categoryId);
//        for (SubCategoryEntity subcat:subcategories
//        ) {
//            if(subcat.getSubCategoryId().equals(subcategoryId))
//                subcat.setCategoryId(newSubcategory.getCategoryId());
//                subcat.setSubCategoryId(newSubcategory.getSubCategoryId());
//                subcat.setImageUrl(newSubcategory.getImageUrl());
//                return subcat;
//        }
//        return null;
        SubCategoryEntity temp = findByCategoryIdSubCategoryId(categoryId,subcategoryId);
        temp.setSubCategoryId(newSubcategory.getSubCategoryId());
        System.out.println(findByCategoryIdSubCategoryId(categoryId,newSubcategory.getSubCategoryId()));
        subCategoryRepo.save(temp);
    }
}
