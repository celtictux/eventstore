package org.celtictux.eventstore.util;

import org.celtictux.eventstore.EventRepository;
import org.celtictux.eventstore.dao.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;

public class EventIdGenerator {

    @Autowired
    private EventRepository repository;

    public int getMaxID() {
        Event id = repository.findAll(Sort.by(Sort.Direction.DESC, "id")).get(0);
        int largestId = id.getId();
        return largestId++;
    }


}
