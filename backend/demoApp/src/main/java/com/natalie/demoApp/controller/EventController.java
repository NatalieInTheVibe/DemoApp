package com.natalie.demoApp.controller;

import com.natalie.demoApp.entity.Event;
import com.natalie.demoApp.entity.Member;
import com.natalie.demoApp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
@RequestMapping("/eventDetails")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/saveEvent")
    public ResponseEntity<String> saveEvent(@RequestBody Event event){
        Long id = eventService.saveEvent(event);
        return new ResponseEntity<String>("Event has been saved with id" + id, HttpStatus.OK);
    }
    @GetMapping("/eventList")
    public ResponseEntity<List<Event>> getAllEventDetails(){
        List<Event> list = eventService.getAllEvents();
        return new ResponseEntity<List<Event>>(list,HttpStatus.OK);
    }

    @GetMapping("/getEventById/{evtNo}")
    public ResponseEntity<Event> getEventById(@PathVariable("evtNo") Long evtNo){
        Event evt = eventService.getEventById(evtNo);
        return new ResponseEntity<Event>(evt,HttpStatus.OK);
    }

    // EventController.java
    @GetMapping("/eventList/{evtNo}/members")
    public ResponseEntity<Object> getEventMembers(@PathVariable Long evtNo) {
        Set<Member> members = eventService.getEventMembers(evtNo);
        if (members != null) {
            return new ResponseEntity<>(members, HttpStatus.OK);
        }
        return new ResponseEntity<>("No member found enrolled for this event.",HttpStatus.NOT_FOUND);
    }



    @PutMapping("/updateEvent/{evtNo}")
    public ResponseEntity<String> updateEvent(@PathVariable("evtNo") Long evtNo, @RequestBody Event event){
        Event eventById = eventService.getEventById(evtNo);
        eventById.setEvtName(event.getEvtName());
        Long id = eventService.saveEvent(eventById);
        return new ResponseEntity<String>("Event with id "+id+"has been saved.", HttpStatus.OK);
    }

    @DeleteMapping("/deleteEvent/{evtNo}")
    public ResponseEntity<String> deleteEvent(@PathVariable("evtNo") Long evtNo){
        eventService.deleteEvent(evtNo);
        return new ResponseEntity<>("Event with '"+evtNo+"' has been deleted.", HttpStatus.OK);
    }


}
