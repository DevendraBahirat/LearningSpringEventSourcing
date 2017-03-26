package com.demo.projection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.demo.persistence.entities.Lead;
import com.demo.persistence.repo.LeadRepo;
import com.demo.store.event.LeadCreatedEvent;

@Service
public class ManagementProjection {

    @Autowired
    private LeadRepo leadRepo;

    @EventListener
    public void onLeadCreated(final LeadCreatedEvent event) {
        leadRepo.save(new Lead(event.getLeadId(), event.getName()));
    }

}
