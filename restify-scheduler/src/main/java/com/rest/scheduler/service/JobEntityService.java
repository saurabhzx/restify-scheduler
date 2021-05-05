package com.rest.scheduler.service;

import com.rest.scheduler.entity.JobEntity;
import com.rest.scheduler.repository.JobEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class JobEntityService {

    @Autowired
    private JobEntityRepository jobEntityRepository;

    public Optional<JobEntity> findById(Long id){
        return jobEntityRepository.findById(id);
    }
}
