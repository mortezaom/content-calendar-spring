package dev.mortezaom.eventcalendar.service;

import dev.mortezaom.eventcalendar.model.Event;
import dev.mortezaom.eventcalendar.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> findAll() {
        return repository.findAll();
    }

    public Optional<Event> findById(Long id) {
        return repository.findById(id);
    }

    public Event save(Event Content) {
        return repository.save(Content);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
