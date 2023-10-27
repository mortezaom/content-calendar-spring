package dev.mortezaom.contentcalendar.service;

import dev.mortezaom.contentcalendar.model.Content;
import dev.mortezaom.contentcalendar.model.Day;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalenderService {
    public List<List<Day>> contentsList(List<Content> contents) {
        System.out.println(contents);
        LocalDate date = LocalDate.now();
        int days = date.getMonth().length(date.isLeapYear());
        List<Day> groupedContents = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            Day day = new Day();
            day.setNumber(i + 1);
            day.setContents(new ArrayList<>());
            groupedContents.add(day);
            for (Content content : contents) {
                var list = groupedContents.get(i).getContents();
                if (content.getDateCreated().getDayOfMonth() == i + 1) {
                    list.add(content);
                }
                groupedContents.get(i).setContents(list);
            }
        }

        // arrange them in order week days (add empty lists to the beginning if needed)
        int firstDayOfWeek = date.withDayOfMonth(1).getDayOfWeek().getValue();
        for (int i = 0; i < firstDayOfWeek - 1; i++) {
            groupedContents.add(0, new Day());
        }

        // arrange them in order week days (add empty lists to the end if needed)
        int lastDayOfWeek = date.withDayOfMonth(days).getDayOfWeek().getValue();
        for (int i = 0; i < 7 - lastDayOfWeek; i++) {
            groupedContents.add(new Day());
        }

        // group them in 7 days array
        List<List<Day>> groupedContentsInWeeks = new ArrayList<>();
        for (int i = 0; i < groupedContents.size(); i += 7) {
            groupedContentsInWeeks.add(groupedContents.subList(i, i + 7));
        }
        return groupedContentsInWeeks;
    }
}
