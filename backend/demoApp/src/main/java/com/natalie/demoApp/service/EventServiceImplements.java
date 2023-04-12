package com.natalie.demoApp.service;

import com.natalie.demoApp.entity.Event;
import com.natalie.demoApp.entity.Member;
import com.natalie.demoApp.exception.RuntimeException;
import com.natalie.demoApp.repos.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EventServiceImplements implements EventService{
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Long saveEvent(Event event){
        return eventRepository.save(event).getEvtNo();
    }

    @Override
    public List<Event> getAllEvents(){
        return (List<Event>) eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long evtNo){
        return eventRepository.findById(evtNo)
                .orElseThrow(()-> new RuntimeException(evtNo));
    }

    @Override
    public Set<Member> getEventMembers(Long evtNo) {
        Optional<Event> eventOpt = eventRepository.findById(evtNo);
        if (eventOpt.isPresent()) {
            Event event = eventOpt.get();
            return event.getMembers();
        }
        return null;
    }


    @Override
    public void deleteEvent(Long evtNo) {
        if (!eventRepository.existsById(evtNo)) {
            throw new RuntimeException(evtNo);
        }
        eventRepository.deleteById(evtNo);
    }



}
