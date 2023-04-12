package com.natalie.demoApp.service;

import com.natalie.demoApp.entity.Event;
import com.natalie.demoApp.entity.Member;

import java.util.List;
import java.util.Set;

public interface EventService {
    Long saveEvent(Event event);

    List<Event> getAllEvents();

    Event getEventById(Long evtNo);

    Set<Member> getEventMembers(Long evtNo);

    void deleteEvent(Long evtNo);
}
