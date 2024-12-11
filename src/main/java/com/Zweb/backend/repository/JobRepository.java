package com.Zweb.backend.repository;

import com.Zweb.backend.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobRepository extends MongoRepository<Job, String> {
     Page<Job> findJobByTitleContainingIgnoreCase(String title, Pageable pageable);
}
