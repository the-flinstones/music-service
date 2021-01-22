package com.flinstone.musicservice.repository;

import com.flinstone.musicservice.entity.UserPlaylistsEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface UserPlaylistsRepo extends CassandraRepository<UserPlaylistsEntity, String> {

    List<UserPlaylistsEntity> findByUserId(String id);
}
