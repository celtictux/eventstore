package org.celtictux.eventstore.util;

import org.celtictux.eventstore.dao.MemberType;

import java.util.HashMap;
import java.util.Map;

public class MemberTypeParser {

    public static Map<MemberType, Integer> parseMap(final Map<String, Integer> members) {
        final Map<MemberType, Integer> parsedMembers = new HashMap<>();
        for (final Map.Entry<String, Integer> entry : members.entrySet()) {
            parsedMembers.put(MemberType.valueOf(entry.getKey()), entry.getValue());
        }
        return parsedMembers;
    }
}
