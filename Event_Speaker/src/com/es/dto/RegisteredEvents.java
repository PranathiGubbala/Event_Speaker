package com.es.dto;

public class RegisteredEvents {
    private Event eventId;
    private Participant pId;
    public Event getEventId() {
        return eventId;
    }
    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }
    public Participant getParticipantId() {
        return pId;
    }
    public void setParticipantId(Participant pId) {
        this.pId = pId;
    }
   
    public String toString() {
        return "registeredEvents [eventId=" + eventId + ", pId=" + pId + "]";
    }
}


