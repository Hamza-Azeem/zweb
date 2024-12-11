package com.Zweb.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document
public class Applicant {
    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String description;
    Set<Job> jobs;

    public Applicant() {
    }

    public Applicant(String name, String email, String phoneNumber, String description) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }
    public void addJob(Job job) {
        if(jobs == null) {
            jobs = new HashSet<>();
        }
        jobs.add(job);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
}
