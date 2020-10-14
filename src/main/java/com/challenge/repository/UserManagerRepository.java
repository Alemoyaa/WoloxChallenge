package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.UserEntity;

@Repository
public interface UserManagerRepository extends JpaRepository<UserEntity, Long> {
}
