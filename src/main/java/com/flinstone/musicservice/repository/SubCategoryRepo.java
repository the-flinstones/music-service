package com.flinstone.musicservice.repository;


import com.flinstone.musicservice.entity.SubCategoryEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface SubCategoryRepo extends CassandraRepository<SubCategoryEntity,String> {
    List<SubCategoryEntity> findByCategoryId(String category);

}
