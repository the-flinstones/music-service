package com.flinstone.musicservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Table("user_details")
@Data
public class UserDetailsEntity {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    private String useremail;
    private String username;
    private Date dob;
    private String country;
    private String type;
}