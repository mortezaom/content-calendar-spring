package dev.mortezaom.contentcalendar.model;

import java.util.List;

public class Day {
    public Integer number;
    public List<Content> contents;

    public Day() {
    }

    public Day(Integer number, List<Content> contents) {
        this.number = number;
        this.contents = contents;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return (number != null) ? number.toString() : "";
    }
}
