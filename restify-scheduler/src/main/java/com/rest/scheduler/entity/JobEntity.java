package com.rest.scheduler.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

import com.rest.scheduler.converter.BooleanToYNConverter;
import com.rest.scheduler.enums.JobHttpAllowedMethod;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "JOB_ENTITY")
@EntityListeners(AuditingEntityListener.class)
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "cron_expression", nullable = false, length = 100)
    private String cronExpression;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;

    @Column(name = "is_active", columnDefinition = "CHAR(1)")
    @Convert(converter= BooleanToYNConverter.class)
    private Boolean isActive = true;

    @OneToMany(mappedBy = "jobEntity", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobRequestHeader> jobRequestHeader;

    @Enumerated(EnumType.STRING)
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

    public String getCronExpression() {
        return this.cronExpression;
    }

    public void setCronExpression(final String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
