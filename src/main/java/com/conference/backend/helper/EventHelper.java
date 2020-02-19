package com.conference.backend.helper;

import com.conference.backend.dto.EventDto;
import com.conference.backend.entity.Event;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * @author Kazim Unalan
 */
public class EventHelper {

    public static void getListTrack(List<Event> events, List<EventDto> track, int trackId, int trackAM, int trackPM) {


    }

    private static Date prepareTrackAM(List<Event> events, List<EventDto> track, int trackId, int trackSize, Date startDate) {
        Date finishDate = startDate;
        for (int i = 0; i < events.size(); ) {
            Event event = events.get(i);
            if (event.getHeader().equals("Cloud Native Java lightning")) {
                i++;
                continue;
            }
            int presentationTime = Integer.parseInt(StringUtils.substringBefore(events.get(i).getPresentationTime(), "min"));
            trackSize = trackSize - presentationTime;
            finishDate = DateUtils.addMinutes(startDate, presentationTime);
            EventDto eventDto = new EventDto(event.getHeader(), "TRACK" + trackId, startDate, finishDate, event.getPresentationTime());
            track.add(eventDto);
            events.remove(event);
            if (trackSize == 0) {
                break;
            } else if (trackSize == 45) {
                finishDate = checkFinalSize(events, track, trackId, trackSize, i, finishDate);
                break;
            } else if (trackSize == 15 || trackSize < 0) {
                track.remove(eventDto);
                events.add(event);
                trackSize = trackSize + presentationTime;
                finishDate = checkFinalSize(events, track, trackId, trackSize, i, startDate);
                break;
            }
            startDate = finishDate;
        }
        return finishDate;

    }

    private static Date checkFinalSize(List<Event> events, List<EventDto> track, int trackId, int trackSize, int i, Date startDate) {
        Event event;
        int presentationTime;
        EventDto eventDto;
        Date finishDate = startDate;
        for (int j = i; j < events.size(); j++) {
            event = events.get(j);
            if (event.getHeader().equals("Cloud Native Java lightning")) {
                i++;
                continue;
            }
            presentationTime = Integer.parseInt(StringUtils.substringBefore(event.getPresentationTime(), "min"));
            if (presentationTime == trackSize) {
                finishDate = DateUtils.addMinutes(startDate, presentationTime);
                eventDto = new EventDto(event.getHeader(), "TRACK" + trackId, startDate, finishDate, event.getPresentationTime());
                track.add(eventDto);
                events.remove(event);
                break;
            }

        }
        return finishDate;
    }
}
