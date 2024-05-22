package com.teamproject.gaxga.repository.event;

import com.teamproject.gaxga.entity.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends CrudRepository<Event, Long> {
    @Override
    List<Event> findAll();

    Iterable<Event> findByStartDate (LocalDateTime startDate);

    Iterable<Event> findByEndDate (LocalDateTime endDate);

    Iterable<Event> findByRegDate (LocalDateTime regDate);

}