package com.demo.commands;

import java.util.UUID;

public final class LeadClickOnPromotionalLinkCommand extends Command {

    private UUID idOfLead;

    //

    public UUID getIdOfLead() {
        return idOfLead;
    }

    public void setIdOfLead(final UUID idOfLead) {
        this.idOfLead = idOfLead;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idOfLead == null) ? 0 : idOfLead.hashCode());
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
        final LeadClickOnPromotionalLinkCommand other = (LeadClickOnPromotionalLinkCommand) obj;
        if (idOfLead == null) {
            if (other.idOfLead != null)
                return false;
        } else if (!idOfLead.equals(other.idOfLead))
            return false;
        return true;
    }

}
