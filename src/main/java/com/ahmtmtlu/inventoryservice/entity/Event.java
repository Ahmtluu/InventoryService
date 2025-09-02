package com.ahmtmtlu.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;

    @Column(name = "name")
     private String name;

    @Column(name = "total_capacity")
     private Long totalCapacity;

    @Column(name = "left_capacity")
     private Long leftCapacity;

    @ManyToOne
    @JoinColumn(name = "venue_id")
     private Venue venue;

}
