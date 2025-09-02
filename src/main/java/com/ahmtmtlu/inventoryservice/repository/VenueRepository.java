package com.ahmtmtlu.inventoryservice.repository;

import com.ahmtmtlu.inventoryservice.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VenueRepository extends JpaRepository<Venue, UUID> {
}
