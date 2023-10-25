package dev.mortezaom.contentcalendar.service;

import dev.mortezaom.contentcalendar.model.Content;
import dev.mortezaom.contentcalendar.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository repository;

    public List<Content> findAll() {
        return repository.findAll();
    }

    public Optional<Content> findById(Long id) {
        return repository.findById(id);
    }

    public Content save(Content Content) {
        return repository.save(Content);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
