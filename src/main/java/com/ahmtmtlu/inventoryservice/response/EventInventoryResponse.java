package com.ahmtmtlu.inventoryservice.response;

import com.ahmtmtlu.inventoryservice.entity.Venue;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventInventoryResponse {

     private String event;
     private Long capacity;
     private Venue venue;
}
