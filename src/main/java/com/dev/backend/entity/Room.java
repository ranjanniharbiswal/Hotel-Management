package com.dev.backend.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Room number is required !!")
    @Column(unique = true)
    private String roomNumber;
    
    @NotBlank(message = "Room type is required !!")
    private String type;
    
    @NotNull(message = "Price is required !!")
    @Positive(message = "Price must be positive !!")
    private BigDecimal price;
    
    private boolean available = true;

        public Room(String roomNumber, String type, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.price = price;
    }
    
}