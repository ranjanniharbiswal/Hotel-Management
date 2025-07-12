package com.dev.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "User ID is required !!")
    @Column(name = "user_id")
    private Long userId;

    @NotNull(message = "Room ID is required !!")
    @Column(name = "room_id")
    private Long roomId;

    @NotNull(message = "Date is required !!")
    private LocalDate date;

    public Booking(Long userId, Long roomId, LocalDate date) {
        this.userId = userId;
        this.roomId = roomId;
        this.date = date;
    }

}
