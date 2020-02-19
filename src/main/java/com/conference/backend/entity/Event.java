package com.conference.backend.entity;

import com.conference.backend.entity.base.BaseEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author Kazim Unalan
 */
@Entity
public class Event extends BaseEntity {

    @NotNull
    private String header;

    private String content;

    @NotNull
    private String presentationTime;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPresentationTime() {
        return presentationTime;
    }

    public void setPresentationTime(String presentationTime) {
        this.presentationTime = presentationTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "header='" + header + '\'' +
                ", content='" + content + '\'' +
                ", presentationTime='" + presentationTime + '\'' +
                '}';
    }
}
