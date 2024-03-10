package com.demo.niq.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shopper_info")
public class Shopper {
    @Id
    @Column(name = "shopper_id")
    private String shopperId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shopperInfo", fetch = FetchType.LAZY)
    private Set<Relevancy> relevancyInfos = new HashSet<>();

    public Shopper() {
    }

    public Shopper(String shopperId) {
        this.shopperId = shopperId;
    }

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public Set<Relevancy> getRelevancyInfos() {
        return relevancyInfos;
    }

    public void addRelevancyInfos(Relevancy relevancyInfo) {
        this.relevancyInfos.add(relevancyInfo);
    }
}
