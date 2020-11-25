package com.flinstone.musicservice.repository;

import com.flinstone.musicservice.entity.CategoryEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Optional;

public interface CategoryRepo  extends CassandraRepository<CategoryEntity,String> {
    Optional<CategoryEntity> findByCategoryId(String id);
}
