package com.ahmtmtlu.inventoryservice.controller;

import com.ahmtmtlu.inventoryservice.entity.Venue;
import com.ahmtmtlu.inventoryservice.response.EventInventoryResponse;
import com.ahmtmtlu.inventoryservice.response.VenueInventoryResponse;
import com.ahmtmtlu.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")

public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/inventory/events")
    public @ResponseBody List<EventInventoryResponse> inventoryGetAllEvents(){
        return inventoryService.getAllEvents();
    }

    @GetMapping("/inventory/venue/{venueId}")
    public @ResponseBody VenueInventoryResponse inventoryByVenueId(@PathVariable("venueId") UUID venueId){

        return inventoryService.getVenueInformation(venueId);

    }

}
