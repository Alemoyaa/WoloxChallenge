package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.AlbumEntity;

@Repository
public interface AlbumManagerRepository extends JpaRepository<AlbumEntity, Long>{

}
