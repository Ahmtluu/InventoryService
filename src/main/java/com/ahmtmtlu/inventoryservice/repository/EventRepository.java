package com.ahmtmtlu.inventoryservice.repository;

import com.ahmtmtlu.inventoryservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
}
