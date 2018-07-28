package org.celtictux.eventstore;

import org.celtictux.eventstore.dao.Event;
import org.celtictux.eventstore.dao.MemberType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class EventStore {

    @Autowired
    private EventRepository repository;

    @RequestMapping("/hello")
    public String index() {
        return "Greetings the Events Endpoint, built on Spring Boot!";
    }

    @RequestMapping("/getAllEvents")
    public Collection<Event> getAllEvents() {
        return repository.findAll();
    }

    @RequestMapping("/addEvent")
    public void addEvent(final String eventName, final String eventLocation) {
        Event event = new Event();
        event.setEventName(eventName);
        event.setEventLocation(eventLocation);

        final Map<MemberType, Integer> members = new HashMap<>();
        members.put(MemberType.FIRST_AIDER, 2);

        event.setEventRequirements(members);
        repository.insert(event);
    }



}
