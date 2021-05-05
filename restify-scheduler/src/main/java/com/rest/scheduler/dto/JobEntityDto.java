package com.rest.scheduler.dto;

import com.rest.scheduler.entity.JobRequestHeader;
import com.rest.scheduler.enums.JobHttpAllowedMethod;
import java.time.LocalDateTime;
import java.util.List;

public class JobEntityDto {

    private Long id;

    private String name;

    private String cronExpression;

    private LocalDateTime created;

    private LocalDateTime modified;

    private Boolean isActive = true;

    private List<JobRequestHeader> jobRequestHeader;

    private JobHttpAllowedMethod jobHttpAllowedMethod;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCronExpression() {
        return this.cronExpression;
    }

    public void setCronExpression(final String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public void setCreated(final LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return this.modified;
    }

    public void setModified(final LocalDateTime modified) {
        this.modified = modified;
    }

    public Boolean getActive() {
        return this.isActive;
    }

    public void setActive(final Boolean active) {
        this.isActive = active;
    }

    public List<JobRequestHeader> getJobRequestHeader() {
        return this.jobRequestHeader;
    }

    public void setJobRequestHeader(final List<JobRequestHeader> jobRequestHeader) {
        this.jobRequestHeader = jobRequestHeader;
    }

    public JobHttpAllowedMethod getJobHttpAllowedMethod() {
        return this.jobHttpAllowedMethod;
    }

    public void setJobHttpAllowedMethod(final JobHttpAllowedMethod jobHttpAllowedMethod) {
        this.jobHttpAllowedMethod = jobHttpAllowedMethod;
    }
}
