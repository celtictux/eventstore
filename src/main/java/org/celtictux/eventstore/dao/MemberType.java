package org.celtictux.eventstore.dao;

public enum MemberType {

    FIRST_AIDER("FA"),
    ADVANCED_FIRST_AIDER("AFA"),
    EMERGENCY_TRANSPORT_ATTENDANT("ETA"),
    DOCTOR("DOC"),
    PARAMEDIC("PARA"),
    DUTY_OFFICER("DO"),
    COMMS("CO"),
    LOGISTICS("LOG"),
    SUPPORT_MEMBER("SM");

    private MemberType(final String memberCode) {
        this.memberCode = memberCode;
    }

    private String memberCode;

    public String memberTypeCode() {
        return this.memberCode;
    }
}
