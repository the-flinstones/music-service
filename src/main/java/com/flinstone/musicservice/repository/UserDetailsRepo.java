package com.flinstone.musicservice.repository;

import com.flinstone.musicservice.entity.UserDetailsEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface UserDetailsRepo extends CassandraRepository<UserDetailsEntity, String> {
}
