package dev.mortezaom.eventcalendar.repository;

import dev.mortezaom.eventcalendar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
