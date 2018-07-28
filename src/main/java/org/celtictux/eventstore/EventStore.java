package org.celtictux.eventstore;

import org.celtictux.eventstore.dao.Event;
import org.celtictux.eventstore.dao.MemberType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RestController
public class EventStore {

    @Autowired
    private EventRepository repository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return "Greetings the Events Endpoint, built on Spring Boot!";
    }

    @RequestMapping(value = "/getAllEvents", method = RequestMethod.GET)
    public Collection<Event> getAllEvents() {
        return repository.findAll();
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.GET)
    public void addEvent(@RequestParam final String eventName,
                         @RequestParam final String eventLocation) {
        Event event = new Event();
        event.setEventName(eventName);
        event.setEventLocation(eventLocation);

        final Map<MemberType, Integer> members = new HashMap<>();
        members.put(MemberType.FIRST_AIDER, 2);

        event.setEventRequirements(members);
        Event insert = repository.insert(event);
        System.out.println("Inserted: " + insert.toString());
    }



}
