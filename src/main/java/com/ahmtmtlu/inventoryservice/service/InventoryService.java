package com.ahmtmtlu.inventoryservice.service;

import com.ahmtmtlu.inventoryservice.response.EventInventoryResponse;
import com.ahmtmtlu.inventoryservice.response.VenueInventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface InventoryService {

    public List<EventInventoryResponse> getAllEvents();

    public VenueInventoryResponse getVenueInformation(UUID venueId);

}
