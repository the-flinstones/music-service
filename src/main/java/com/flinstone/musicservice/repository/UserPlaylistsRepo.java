package com.flinstone.musicservice.repository;

import com.flinstone.musicservice.entity.UserPlaylistsEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserPlaylistsRepo extends CassandraRepository<UserPlaylistsEntity, String> {
}
