package com.rest.scheduler.job;

import com.rest.scheduler.entity.JobEntity;
import com.rest.scheduler.service.JobEntityService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class JobEntityJob implements Job {

    @Autowired
    JobEntityService jobEntityService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        /* Get job entity id recorded by scheduler during scheduling */
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobEntityId = dataMap.getString("jobEntityId");

        /* Get message from database by id */
        Long id = Long.parseLong(jobEntityId);
        Optional<JobEntity> jobEntityOptional = jobEntityService.findById(id);

        JobEntity jobEntity = jobEntityOptional.get();

    }
}
