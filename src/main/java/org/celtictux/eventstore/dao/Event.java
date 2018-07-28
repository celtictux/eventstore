package org.celtictux.eventstore.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Map;

@Data
public class Event {

    @Id
    public String id;

    public String eventName;
    public String eventLocationNumber;
    public String eventLocationRoad;
    public String eventLocationCounty;

    public Map<MemberType, Integer> eventRequirements;

}
