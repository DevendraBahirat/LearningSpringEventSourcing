package com.demo.store;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.persistence.entities.RawEvent;
import com.demo.persistence.repo.RawEventRepo;
import com.demo.store.event.BaseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
@Transactional
public class EventStore {

    private ObjectMapper mapper;

    @Autowired
    private RawEventRepo eventRepo;

    //

    public long save(final BaseEvent event) {
        return eventRepo.save(convert(event)).getId();
    }

    //

    private RawEvent convert(final BaseEvent event) {
        final RawEvent rawEvent = new RawEvent();
        rawEvent.setType(event.getClass().getCanonicalName());
        rawEvent.setCorrelationId(event.getCorrelationId());

        String eventAsString = null;
        try {
            eventAsString = mapper.writeValueAsString(event);
        } catch (final JsonProcessingException ex) {
            throw new IllegalStateException("Error serializing the event: " + event.toString(), ex);
        }
        rawEvent.setPayload(eventAsString);

        return rawEvent;
    }

    @PostConstruct
    void instantiate() {
        this.mapper = new ObjectMapper();
    }

}
