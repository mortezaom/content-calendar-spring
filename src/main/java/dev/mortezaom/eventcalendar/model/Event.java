package dev.mortezaom.eventcalendar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String occasion;

    private Long invited_count;

    private Integer year;
    private Integer month;
    private Integer day;

    public Event() {
    }

    public Event(String occasion, Long invited_count, Integer year, Integer month, Integer day) {
        this.occasion = occasion;
        this.invited_count = invited_count;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // create object from json string
    public static Event fromText(String text) {
        String[] parts = text.split("\\|");
        return new Event(parts[0], Long.parseLong(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public Long getInvited_count() {
        return invited_count;
    }

    public void setInvited_count(Long invited_count) {
        this.invited_count = invited_count;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}
