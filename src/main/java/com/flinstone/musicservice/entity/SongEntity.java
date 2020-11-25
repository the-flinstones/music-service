package com.flinstone.musicservice.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table("song")
@Data
public class SongEntity {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private Set<String> tags = new HashSet<>();
    private String title;
    private String genre;
    private String releaseDate =new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    private String artist;
    private String language;
    private String album;

}
