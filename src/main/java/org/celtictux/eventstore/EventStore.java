package org.celtictux.eventstore;

import org.celtictux.eventstore.dao.Event;
import org.celtictux.eventstore.dao.MemberType;
import org.celtictux.eventstore.util.EventIdGenerator;
import org.celtictux.eventstore.util.MemberTypeParser;
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

    @Autowired
    private EventIdGenerator generator;

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
            @RequestParam final String eventLocation,
            @RequestParam final Map<String, Integer> requirements) {
        Event event = new Event();
        event.setId(generator.getMaxID());
        event.setEventName(eventName);
        event.setEventLocation(eventLocation);

        event.setEventRequirements(MemberTypeParser.parseMap(requirements));
        Event insert = repository.insert(event);
        System.out.println("Inserted: " + insert.toString());
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAll() {
        repository.deleteAll();
    }
}
