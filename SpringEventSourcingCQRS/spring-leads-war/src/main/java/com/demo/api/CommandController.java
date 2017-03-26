package com.demo.api;

import com.demo.commands.CreateLeadCommand;
import com.demo.commands.LeadClickOnPromotionalLinkCommand;
import com.demo.store.EventStore;
import com.demo.store.event.LeadClickedOnPromotionalLinkEvent;
import com.demo.store.event.LeadCreatedEvent;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/commands")
class CommandController {

    @Autowired
    private EventStore eventStore;

    //

    @RequestMapping(value = "/leads", method = RequestMethod.POST)
    public void crateLead(final @Valid @RequestBody CreateLeadCommand createLeadCommand) {
        final LeadCreatedEvent event = new LeadCreatedEvent(UUID.randomUUID(), UUID.randomUUID(), createLeadCommand.getName());

        eventStore.save(event);
    }

    @RequestMapping(value = "/leads/activity", method = RequestMethod.POST)
    public void leadClickOnPromotionalLink(final @Valid @RequestBody LeadClickOnPromotionalLinkCommand leadClickOnPromotionalLinkCommand) {
        final UUID correllationId = UUID.randomUUID();

        final LeadClickedOnPromotionalLinkEvent event = new LeadClickedOnPromotionalLinkEvent(leadClickOnPromotionalLinkCommand.getIdOfLead());
        event.setCorrelationId(correllationId);

        eventStore.save(event);
    }

}
