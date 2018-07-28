package org.celtictux.eventstore.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
public class Event {

    @Id
    public int id;

    public String eventName;
    public String eventLocation;

    public Map<MemberType, Integer> eventRequirements;

}
