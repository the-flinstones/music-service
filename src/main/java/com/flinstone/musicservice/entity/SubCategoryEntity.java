package com.flinstone.musicservice.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("subcategory")
@Data
public class SubCategoryEntity {
    @PrimaryKeyColumn(name = "category",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String categoryId;
    @PrimaryKeyColumn(name = "subcategory",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private String subCategoryId;
    private String imageUrl;

}
