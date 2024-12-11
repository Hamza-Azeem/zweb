package com.Zweb.backend.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class Application {
    private String id;
    private Applicant applicant;
    private Job job;
    private LocalDate date;

    public Application() {
    }

    public Application(Job job, Applicant applicant, LocalDate date) {
        this.job = job;
        this.applicant = applicant;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public Job getJob() {
        return job;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
