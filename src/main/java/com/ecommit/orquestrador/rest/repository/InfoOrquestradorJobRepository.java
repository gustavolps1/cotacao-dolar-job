package com.ecommit.orquestrador.rest.repository;

import com.ecommit.orquestrador.rest.entity.InfoOrquestradorJobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoOrquestradorJobRepository extends JpaRepository<InfoOrquestradorJobEntity, Long> {
}
