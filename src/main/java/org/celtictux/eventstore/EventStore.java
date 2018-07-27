package org.celtictux.eventstore;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventStore {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


}
