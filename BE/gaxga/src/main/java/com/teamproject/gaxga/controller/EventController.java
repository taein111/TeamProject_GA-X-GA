package com.teamproject.gaxga.controller;


import com.teamproject.gaxga.entity.Event;
import com.teamproject.gaxga.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/event")
@Controller
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public String eventShow(Model model){
        return eventService.getAllEvents(model);
    }

//    @GetMapping("/event/{id}")
//    public Event getEventById(@PathVariable Long id) {
//        return eventService.getEventById(id);
//    }
}