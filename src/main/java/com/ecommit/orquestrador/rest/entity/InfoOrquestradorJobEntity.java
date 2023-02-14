package com.ecommit.orquestrador.rest.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "info_orquestrador_job")
public class InfoOrquestradorJobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_orquestrador_job_id")
    private Long infoOrquestradorJobId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "started_at")
    private Date startedAt;

    @Column(name = "finish_at")
    private Date finishAt;

    @Column(name = "job_id")
    private String jobId;

    public InfoOrquestradorJobEntity() {
    }

    public InfoOrquestradorJobEntity(Date createdAt, Date startedAt, Date finishAt, String jobId) {
        this.createdAt = createdAt;
        this.startedAt = startedAt;
        this.finishAt = finishAt;
        this.jobId = jobId;
    }

    public Long getInfoOrquestradorJobId() {
        return infoOrquestradorJobId;
    }

    public void setInfoOrquestradorJobId(Long infoOrquestradorJobId) {
        this.infoOrquestradorJobId = infoOrquestradorJobId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(Date finishAt) {
        this.finishAt = finishAt;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
