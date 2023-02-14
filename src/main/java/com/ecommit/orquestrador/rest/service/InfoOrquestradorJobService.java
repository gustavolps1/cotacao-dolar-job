package com.ecommit.orquestrador.rest.service;

import com.ecommit.orquestrador.rest.entity.InfoOrquestradorJobEntity;
import com.ecommit.orquestrador.rest.repository.InfoOrquestradorJobRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class InfoOrquestradorJobService {

    private final InfoOrquestradorJobRepository repository;

    public InfoOrquestradorJobService(InfoOrquestradorJobRepository repository) {
        this.repository = repository;
    }

    public Long save(Date createdAt, Date startedAt, Date finishAt, String jobName){
        InfoOrquestradorJobEntity entity = new InfoOrquestradorJobEntity(createdAt, startedAt, finishAt, jobName);
        entity = repository.saveAndFlush(entity);
        return entity.getInfoOrquestradorJobId();
    }
}
