package com.Zweb.backend.entity;

import com.Zweb.backend.models.Requirements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document
public class Job {
    @Id
    private String id;
    private String title;
    private String type;
    private String description;
    private LocalDateTime openDate;
    private LocalDateTime deadline;
    private List<Requirements> requirements;
    private Long salary;
    private Long commission;
    private String workTimeFrom;
    private String workTimeTo;
    private String workDayFrom;
    private String workDayTo;
    private String location;

    public Job(String id,
               String title,
               String type,
               String description,
               LocalDateTime openDate,
               LocalDateTime deadline,
               List<Requirements> requirements,
               Long salary,
               Long commission, String workTimeFrom, String workTimeTo, String workDayFrom, String workDayTo, String location) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.openDate = openDate;
        this.deadline = deadline;
        this.requirements = requirements;
        this.salary = salary;
        this.commission = commission;
        this.workTimeFrom = workTimeFrom;
        this.workTimeTo = workTimeTo;
        this.workDayFrom = workDayFrom;
        this.workDayTo = workDayTo;
        this.location = location;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Long getCommission() {
        return commission;
    }

    public void setCommission(Long commission) {
        this.commission = commission;
    }

    public String getWorkTimeFrom() {
        return workTimeFrom;
    }

    public void setWorkTimeFrom(String workTimeFrom) {
        this.workTimeFrom = workTimeFrom;
    }

    public String getWorkTimeTo() {
        return workTimeTo;
    }

    public void setWorkTimeTo(String workTimeTo) {
        this.workTimeTo = workTimeTo;
    }

    public String getWorkDayFrom() {
        return workDayFrom;
    }

    public void setWorkDayFrom(String workDayFrom) {
        this.workDayFrom = workDayFrom;
    }

    public String getWorkDayTo() {
        return workDayTo;
    }

    public void setWorkDayTo(String workDayTo) {
        this.workDayTo = workDayTo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public LocalDateTime getDeadLine() {
        return deadline;
    }

    public void setDeadLine(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public List<Requirements> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirements> requirements) {
        this.requirements = requirements;
    }
    public void updateRequirements(List<Requirements> requirements) {
        List<Requirements> temp = new ArrayList<>();
        for(int i=0; i<requirements.size(); i++){
            requirements.get(i).setNo(i+1);
            temp.add(requirements.get(i));
        }
        this.requirements = temp;
    }
}
