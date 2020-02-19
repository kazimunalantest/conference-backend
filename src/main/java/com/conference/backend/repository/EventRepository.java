package com.conference.backend.repository;

import com.conference.backend.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kazim Unalan
 */
@Repository
public interface EventRepository extends JpaRepository<Event, String> {
}
