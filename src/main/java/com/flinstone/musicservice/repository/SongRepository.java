package com.flinstone.musicservice.repository;

import com.flinstone.musicservice.entity.SongEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface SongRepository extends CassandraRepository<SongEntity,String> {
}
