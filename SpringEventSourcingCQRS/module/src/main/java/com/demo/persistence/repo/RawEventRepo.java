package com.demo.persistence.repo;

import com.demo.persistence.entities.RawEvent;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RawEventRepo extends JpaRepository<RawEvent, Long> {

    RawEvent findOneByCorrelationId(UUID correlationId);

    List<RawEvent> findAllByCorrelationId(UUID correlationId);

}
