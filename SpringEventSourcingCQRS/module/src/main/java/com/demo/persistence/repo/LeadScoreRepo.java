package com.demo.persistence.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.persistence.entities.LeadScore;

public interface LeadScoreRepo extends JpaRepository<LeadScore, Long> {

    LeadScore findOneByLeadId(final UUID leadId);

}
