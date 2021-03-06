package com.demo.store.event;

import java.util.UUID;

public class LeadCreatedEvent extends BaseEvent {

    private UUID leadId;

    private String name;

    public LeadCreatedEvent() {
        super();
    }

    public LeadCreatedEvent(final UUID correlationId, final UUID leadId, final String name) {
        super(correlationId);

        this.leadId = leadId;
        this.name = name;
    }

    //

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public UUID getLeadId() {
        return leadId;
    }

    public void setLeadId(final UUID leadId) {
        this.leadId = leadId;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((leadId == null) ? 0 : leadId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final LeadCreatedEvent other = (LeadCreatedEvent) obj;
        if (leadId == null) {
            if (other.leadId != null)
                return false;
        } else if (!leadId.equals(other.leadId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
