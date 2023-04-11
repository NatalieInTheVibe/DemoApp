package com.natalie.demoApp.repos;

import com.natalie.demoApp.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}
