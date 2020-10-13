package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.PermitsEntity;

@Repository
public interface PermitsManagerRepository extends JpaRepository<PermitsEntity, Long>{

}
