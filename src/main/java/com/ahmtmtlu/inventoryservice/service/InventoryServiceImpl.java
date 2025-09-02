package com.ahmtmtlu.inventoryservice.service;

import com.ahmtmtlu.inventoryservice.entity.Event;
import com.ahmtmtlu.inventoryservice.entity.Venue;
import com.ahmtmtlu.inventoryservice.repository.EventRepository;
import com.ahmtmtlu.inventoryservice.repository.VenueRepository;
import com.ahmtmtlu.inventoryservice.response.EventInventoryResponse;
import com.ahmtmtlu.inventoryservice.response.VenueInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService{

     private final EventRepository eventRepository;
     private final VenueRepository venueRepository;

     @Autowired
    public InventoryServiceImpl(EventRepository eventRepository, VenueRepository venueRepository) {
        this.eventRepository = eventRepository;
        this.venueRepository = venueRepository;
    }

    @Override
    public List<EventInventoryResponse> getAllEvents() {

         final List<Event> events = eventRepository.findAll();

        return  events.stream().map(
                event -> EventInventoryResponse.builder()
                        .event(event.getName())
                        .venue(event.getVenue())
                        .capacity(event.getLeftCapacity())
                        .build()).collect(Collectors.toList());
    }

    @Override
    public VenueInventoryResponse getVenueInformation(UUID venueId) {
         final Venue venue = venueRepository.findById(venueId).orElse(null);
         return VenueInventoryResponse.builder()
                 .id(venue.getId())
                 .name(venue.getName())
                 .totalCapacity(venue.getTotalCapacity())
                 .build();
    }
}
