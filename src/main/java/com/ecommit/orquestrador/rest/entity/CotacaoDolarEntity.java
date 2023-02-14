package com.ecommit.orquestrador.rest.entity;

import javax.persistence.*;

@Entity
@Table(name = "cotacao_dolar")
public class CotacaoDolarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cotacao_dolar_id")
    private Long cotacaoDolarId;

    @Column(name = "job_id")
    private Long jobId;

    @Column(name = "price")
    private String price;

    @Column(name = "quotation")
    private String quotation;

    public CotacaoDolarEntity() {
    }

    public CotacaoDolarEntity(Long jobId, String price, String quotation) {
        this.jobId = jobId;
        this.price = price;
        this.quotation = quotation;
    }

    public Long getCotacaoDolarId() {
        return cotacaoDolarId;
    }

    public void setCotacaoDolarId(Long cotacaoDolarId) {
        this.cotacaoDolarId = cotacaoDolarId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuotation() {
        return quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }
}
