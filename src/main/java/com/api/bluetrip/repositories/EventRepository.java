package com.api.bluetrip.repositories;

import com.api.bluetrip.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
