package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.Event;
import com.teamproject.gaxga.repository.event.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // 이벤트 저장
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    // 모든 이벤트 가져오기
    public String getAllEvents(Model model) {
        List<Event> AllEvent = eventRepository.findAll();
        model.addAttribute("AllEvent", AllEvent);
        return "public/event/event";
    }

    // ID로 이벤트 가져오기
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

}
