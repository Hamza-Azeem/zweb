package com.Zweb.backend.models;

public class JobCreationResponse {
    private String jobName;
    private String jobId;

    public JobCreationResponse(String jobName, String jobId) {
        this.jobName = jobName;
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
