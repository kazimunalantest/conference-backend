package com.conference.backend.enums;

/**
 * @author Kazim Unalan
 */
public enum EventEnum {
    NORMAL("normal"),
    NETWORKING("networking");

    private String eventEnum;

    EventEnum(String eventEnum) {
        this.eventEnum = eventEnum;
    }

    public String eventEnum() {
        return eventEnum;
    }
}
