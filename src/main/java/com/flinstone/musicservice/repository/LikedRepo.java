package com.flinstone.musicservice.repository;

import com.flinstone.musicservice.entity.Liked;
import com.flinstone.musicservice.entity.Recent;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LikedRepo  extends CassandraRepository<Liked,String> {

    Optional<Liked> findByUserId(String userId);
}