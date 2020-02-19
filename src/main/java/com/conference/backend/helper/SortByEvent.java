package com.conference.backend.helper;

import com.conference.backend.entity.Event;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

/**
 * @author Kazim Unalan
 */
public class SortByEvent implements Comparator<Event> {

    public int compare(Event first, Event second) {
        int firstt = Integer.parseInt(StringUtils.substringBefore(first.getPresentationTime(), "min"));
        int secondd = Integer.parseInt(StringUtils.substringBefore(second.getPresentationTime(), "min"));
        return firstt - secondd;
    }

}
