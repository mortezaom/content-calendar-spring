package dev.mortezaom.contentcalendar.controller;

import dev.mortezaom.contentcalendar.model.Content;
import dev.mortezaom.contentcalendar.repository.ContentRepository;
import dev.mortezaom.contentcalendar.service.CalenderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class MainController {

    private final ContentRepository repository;
    private final CalenderService service;

    public MainController(ContentRepository repository, CalenderService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("contents", service.contentsList(repository.findAll()));
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView createForm(@RequestParam int day) {
        ModelAndView modelAndView = new ModelAndView("new");
        LocalDate date = LocalDate.now();
        modelAndView.addObject("month", date.getMonth().name());
        modelAndView.addObject("day", day);
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createItem(@RequestParam String title, @RequestParam String description, @RequestParam int day) {
        var item = repository.save(new Content(title, description, LocalDate.now().withDayOfMonth(day), null));
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/{id}")
    public ModelAndView getItem(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("item");
        // get the item from the database
        var item = repository.findById(id).orElseThrow();
        modelAndView.addObject("item", item);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/update")
    public ModelAndView updateItem(@RequestParam String id, @RequestParam String title, @RequestParam String description) {
        var item = repository.findById(Long.parseLong(id)).orElseThrow();
        item.setTitle(title);
        item.setDescription(description);
        item.setDateUpdated(LocalDate.now());
        repository.save(item);
        return new ModelAndView("redirect:/");
    }
}
