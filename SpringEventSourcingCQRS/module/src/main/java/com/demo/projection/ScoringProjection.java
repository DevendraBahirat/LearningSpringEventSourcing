package com.demo.projection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.demo.persistence.entities.LeadScore;
import com.demo.persistence.repo.LeadScoreRepo;
import com.demo.store.event.LeadClickedOnPromotionalLinkEvent;
import com.demo.store.event.LeadCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class ScoringProjection {

    @Autowired
    private LeadScoreRepo leadScoreRepo;

    //

    @EventListener
    public void onLeadCreatedCalculateScore(final LeadCreatedEvent event) {
        final int initialScore = calculateInitialScoreOfLead(event);
        leadScoreRepo.save(new LeadScore(event.getLeadId(), initialScore));
    }

    @EventListener
    public void onLeadClickedOnPromotionalLinkReCalculateScore(final LeadClickedOnPromotionalLinkEvent event) {
        final LeadScore existingScore = leadScoreRepo.findOneByLeadId(event.getIdOfLead());
        final int newScore = recalculateScoreOfLead(event, existingScore.getScore());
        existingScore.setScore(newScore);

        leadScoreRepo.save(existingScore);
    }

    //

    private final int calculateInitialScoreOfLead(final LeadCreatedEvent event) {
        return 10;
    }

    private final int recalculateScoreOfLead(final LeadClickedOnPromotionalLinkEvent event, final int oldScore) {
        return oldScore + 1;
    }

}
