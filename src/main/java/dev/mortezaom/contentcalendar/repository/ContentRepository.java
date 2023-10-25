package dev.mortezaom.contentcalendar.repository;

import dev.mortezaom.contentcalendar.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
    
}
