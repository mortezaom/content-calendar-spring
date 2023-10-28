package dev.mortezaom.eventcalendar.controller;

import dev.mortezaom.eventcalendar.model.Event;
import dev.mortezaom.eventcalendar.repository.EventRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/events")
public class MainController {

    private final EventRepository repository;

    public MainController(EventRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public ModelAndView getHome() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("events", repository.findAll());
        modelAndView.addObject("email", authentication.getName());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView createItem(@RequestParam String event) {
        repository.save(Event.fromText(event));
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/delete/{id}")
    public ModelAndView deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/");
    }
}
