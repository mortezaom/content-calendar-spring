package dev.mortezaom.contentcalendar.controller;

import dev.mortezaom.contentcalendar.repository.ContentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class MainController {

    private final ContentRepository repository;

    public MainController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("title", "Content Calendar");
        modelAndView.addObject("contents", repository.findAll());
        return modelAndView;
    }

}
