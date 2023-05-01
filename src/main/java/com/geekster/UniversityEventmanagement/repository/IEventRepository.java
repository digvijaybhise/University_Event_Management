package com.geekster.UniversityEventmanagement.repository;

import com.geekster.UniversityEventmanagement.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IEventRepository extends CrudRepository<Event,Integer> {
    public Iterable<Event> findAllEventByDate(LocalDate date);

}
