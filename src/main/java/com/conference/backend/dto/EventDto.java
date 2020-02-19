package com.conference.backend.dto;

import java.util.Date;

/**
 * @author Kazim Unalan
 */
public class EventDto {

    private String oid;
    private String header;
    private String content;
    private Date startDate;
    private Date finishDate;

    private String presentationTime;

    public EventDto() {
    }

    public EventDto(String header, String content, Date startDate, Date finishDate, String presentationTime) {
        this.header = header;
        this.content = content;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.presentationTime = presentationTime;
    }

    public EventDto(String oid, String header, String presentationTime) {
        this.oid = oid;
        this.header = header;
        this.presentationTime = presentationTime;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getPresentationTime() {
        return presentationTime;
    }

    public void setPresentationTime(String presentationTime) {
        this.presentationTime = presentationTime;
    }
}
