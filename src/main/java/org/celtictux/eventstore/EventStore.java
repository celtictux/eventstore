package org.celtictux.eventstore;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class EventStore {

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }


}
