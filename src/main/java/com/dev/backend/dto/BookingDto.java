package com.dev.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    @NotNull(message = "User ID is required !!")
    private Long userId;

    @NotNull(message = "Room ID is required !!")
    private Long roomId;

    @NotNull(message = "Date is required !!")
    private LocalDate date;

}