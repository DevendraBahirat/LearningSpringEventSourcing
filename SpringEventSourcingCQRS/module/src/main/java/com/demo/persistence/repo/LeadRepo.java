package com.demo.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.persistence.entities.Lead;

public interface LeadRepo extends JpaRepository<Lead, Long> {

    Lead findOneByName(final String name);

}
