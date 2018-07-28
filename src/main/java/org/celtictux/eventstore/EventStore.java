package org.celtictux.eventstore;

import org.celtictux.eventstore.dao.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Controller
@RestController("/events")
public class EventStore {

    @Autowired
    private EventRepository repository;

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public Collection<Event> getAllEvents() {
        return repository.findAll();
    }



}
