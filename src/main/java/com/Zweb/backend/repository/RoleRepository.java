package com.Zweb.backend.repository;

import com.Zweb.backend.entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(String name);
}
