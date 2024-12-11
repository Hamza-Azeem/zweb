package com.Zweb.backend.dto;
import com.Zweb.backend.marker.OnCreate;
import com.Zweb.backend.marker.OnUpdate;
import com.Zweb.backend.models.Requirements;
import com.Zweb.backend.validation.OptionalMin;
import com.Zweb.backend.validation.OptionalNotBlank;
import com.Zweb.backend.validation.OptionalNotEmptyList;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobDto {
    private String id;
    @NotBlank(message = "Title can't be empty", groups = OnCreate.class)
    @OptionalNotBlank(groups = OnUpdate.class)
    private String title;
    @NotBlank(message = "Type can't be empty", groups = OnCreate.class)
    @OptionalNotBlank(groups = OnUpdate.class)
    private String type;
    @NotBlank(message = "Description can't be empty", groups = OnCreate.class)
    @OptionalNotBlank(groups = OnUpdate.class)
    private String description;
    @NotNull(message = "Open date can't be empty", groups = OnCreate.class)
    @Future(message = "Open date must be in the future", groups = {OnUpdate.class, OnCreate.class})
    private LocalDateTime openDate;
    @NotNull(message = "Deadline date can't be empty", groups = OnCreate.class)
    @Future(message = "Deadline date must be in the future", groups = {OnUpdate.class, OnCreate.class})
    private LocalDateTime deadline;
    @NotEmpty(message = "The list must not be empty", groups = OnCreate.class)
    @OptionalNotEmptyList(groups = OnUpdate.class)
    private List<Requirements> requirements;
    @NotNull(message = "Salary can't be null", groups = OnCreate.class)
    @Min(value = 1, message = "Salary must be greater than or equal to 1")
    @OptionalMin(groups = OnUpdate.class)
    private Long salary;
    @NotNull(message = "Salary can't be null", groups = OnCreate.class)
    @Min(value = 1, groups = OnCreate.class)
    @OptionalMin(groups = OnUpdate.class)
    private Long commission;
    @NotBlank(message = "Work time from can't be empty", groups = OnCreate.class)
    @OptionalNotBlank(groups = OnUpdate.class)
    private String workTimeFrom;
    @NotBlank(message = "Work time to can't be empty", groups = OnCreate.class)
    @OptionalNotBlank(groups = OnUpdate.class)
    private String workTimeTo;
    @NotBlank(message = "Work time from can't be empty", groups = OnCreate.class)
    @OptionalNotBlank( groups = OnUpdate.class)
    private String workDayFrom;
    @NotBlank(message = "Work day to can't be empty", groups = OnCreate.class)
    @OptionalNotBlank(groups = OnUpdate.class)
    private String workDayTo;
    @NotBlank(message = "Location can't be empty", groups = OnCreate.class)
    @OptionalNotBlank(groups = OnUpdate.class)
    private String location;

    public JobDto() {
    }

    public JobDto(String id, String title, String type, String description, LocalDateTime openDate) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.openDate = openDate;
    }

    public JobDto(String id, String title, String type, String description, LocalDateTime openDate, LocalDateTime deadline, List<Requirements> requirements, Long salary, Long commission, String workTimeFrom, String workTimeTo, String workDayFrom, String workDayTo, String location) {
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

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public List<Requirements> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<Requirements> requirements) {
        this.requirements = requirements;
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
}
