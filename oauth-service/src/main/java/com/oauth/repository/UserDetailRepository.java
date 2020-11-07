package com.oauth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oauth.model.User;

public interface UserDetailRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUsername(String username);
}
