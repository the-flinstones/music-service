package com.flinstone.musicservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.HashSet;
import java.util.Set;

@Table("recent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recent {
    @PrimaryKey
    private String userId;
    private Set<SongEntity> recentlyPlayedSongs = new HashSet<>();

}
