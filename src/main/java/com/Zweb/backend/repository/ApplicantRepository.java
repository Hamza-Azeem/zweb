package com.Zweb.backend.repository;

import com.Zweb.backend.entity.Applicant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ApplicantRepository extends MongoRepository<Applicant, String> {
    Optional<Applicant> findByEmail(String email);
}
