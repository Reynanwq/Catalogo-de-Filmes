package com.api.catalogo_filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.catalogo_filmes.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
