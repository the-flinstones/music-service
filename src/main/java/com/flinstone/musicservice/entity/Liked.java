package com.flinstone.musicservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table("liked")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Liked {
    @PrimaryKey
    private String userId;
    private List<SongEntity> likedSongs = new ArrayList<>();


}

