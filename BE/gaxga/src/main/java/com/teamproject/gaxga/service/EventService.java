package com.teamproject.gaxga.service;

import com.teamproject.gaxga.entity.Event;
import com.teamproject.gaxga.entity.Gabowatdago;
import com.teamproject.gaxga.repository.GabowatdagoRepository;
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

    @Autowired
    private GabowatdagoRepository gabowatdagoRepository;
    // 이벤트 저장
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    // 모든 이벤트 가져오기
    public String getAllEvents(Model model) {
        List<Event> AllEvent = eventRepository.findAll();
        List<Gabowatdago> eventLikeWinningList = gabowatdagoRepository.findTop3ByLikeCountAndDateRangeWithoutDuplicateWinners();
//        List<Gabowatdago> eventBoardWinningList = gabowatdagoRepository.findTop3UsersByPostCount(); todo 게시글작성 순위 선정해야함 부적합한 열이름 오류
        System.out.println("=========================eventWinningList==============:" +eventLikeWinningList);
//        System.out.println("=========================boardWinningList==============:" +eventBoardWinningList);
        model.addAttribute("Winner", eventLikeWinningList);
        model.addAttribute("Event", AllEvent);
        return "public/event/event";
    }

    // ID로 이벤트 가져오기
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

}
