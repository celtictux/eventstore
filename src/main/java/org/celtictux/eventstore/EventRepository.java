package org.celtictux.eventstore;

import org.celtictux.eventstore.dao.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {

}