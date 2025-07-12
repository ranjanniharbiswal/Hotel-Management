package com.dev.backend.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.backend.dto.ApiResponse;
import com.dev.backend.dto.BookingDto;
import com.dev.backend.entity.Booking;
import com.dev.backend.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<ApiResponse> bookRoom(@Valid @RequestBody BookingDto bookingDto) {
        try {
            Booking booking = bookingService.bookRoom(bookingDto);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "Room booked successfully !!", booking));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Unexpected error during booking: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse> seeAllBookings() {
        try {
            var bookings = bookingService.getAllBookings();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse(true, "All bookings fetched successfully !!", bookings));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, "Failed to fetch bookings: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Unexpected error fetching bookings: " + e.getMessage()));
        }
    }
}
