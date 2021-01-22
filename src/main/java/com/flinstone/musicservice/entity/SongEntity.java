package com.flinstone.musicservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Data
@UserDefinedType(value = "song")
public class SongEntity {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    //    private Set<String> tags = new HashSet<>();
    private String title;
    private String mood;
    private String addedDate =new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    private int year;
    private String artist;
    private String actor;
    private String language;
    private String album;
    private String thumbnailUrl;
    private String bannerUrl;
    private String songUrl;
    private String songLyrics;
    private int likesCount;
    private int playedCount;
    @Override
    public boolean equals(Object obj)
    {   // checking if both the object references are
        // referring to the same object.
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        // type casting of the argument.
        SongEntity songEntity = (SongEntity) obj;

        // comparing the state of argument with
        // the state of 'this' Object.
        return (songEntity.getId() == this.getId());
    }
}
