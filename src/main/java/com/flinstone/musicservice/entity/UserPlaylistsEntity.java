package com.flinstone.musicservice.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table("user_playlists")
@Data
public class UserPlaylistsEntity {

    @PrimaryKeyColumn(name = "user_id",ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String userId;
    @PrimaryKeyColumn(name = "playlist_id",ordinal = 0,type = PrimaryKeyType.CLUSTERED)
    private String playlistId = UUID.randomUUID().toString();

    private String title;
    private List<String> songId;
}


