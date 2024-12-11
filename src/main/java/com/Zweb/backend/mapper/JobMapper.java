package com.Zweb.backend.mapper;

import com.Zweb.backend.dto.JobDto;
import com.Zweb.backend.entity.Job;

public class JobMapper {
    public static JobDto convertToCompleteJobDto(Job job) {
        return new JobDto(
                job.getId(),
                job.getTitle(),
                job.getType(),
                job.getDescription(),
                job.getOpenDate(),
                job.getDeadLine(),
                job.getRequirements(),
                job.getSalary(),
                job.getCommission(),
                job.getWorkTimeFrom(),
                job.getWorkTimeTo(),
                job.getWorkDayFrom(),
                job.getWorkDayTo(),
                job.getLocation()

        );
    }
    public static Job convertToJob(JobDto jobDto){
        return new Job(
                jobDto.getId(),
                jobDto.getTitle(),
                jobDto.getType(),
                jobDto.getDescription(),
                jobDto.getOpenDate(),
                jobDto.getDeadline(),
                jobDto.getRequirements(),
                jobDto.getSalary(),
                jobDto.getCommission(),
                jobDto.getWorkTimeFrom(),
                jobDto.getWorkTimeTo(),
                jobDto.getWorkDayFrom(),
                jobDto.getWorkDayTo(),
                jobDto.getLocation()
        );
    }
    public static JobDto convertToPartialJobDto(Job job) {
        return new JobDto(
                job.getId(),
                job.getTitle(),
                job.getType(),
                job.getDescription(),
                job.getOpenDate()
        );
    }
}
