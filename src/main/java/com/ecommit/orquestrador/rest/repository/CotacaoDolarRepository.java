package com.ecommit.orquestrador.rest.repository;

import com.ecommit.orquestrador.rest.entity.CotacaoDolarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoDolarRepository extends JpaRepository<CotacaoDolarEntity, Long> {
}
