package com.flinstone.musicservice.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("category")
@Data
public class CategoryEntity {
    @PrimaryKey
    private String categoryId;
}
