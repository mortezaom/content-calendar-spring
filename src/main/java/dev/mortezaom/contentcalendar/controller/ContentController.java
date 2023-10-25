package dev.mortezaom.contentcalendar.controller;

import dev.mortezaom.contentcalendar.model.Content;
import dev.mortezaom.contentcalendar.repository.ContentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findOne(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOne(@RequestBody Content body) {
        repository.save(body);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Content createOne(@RequestBody Content content) {
        return repository.save(content);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOne(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
