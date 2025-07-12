package com.dev.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.backend.dto.BookingDto;
import com.dev.backend.entity.Booking;
import com.dev.backend.entity.Room;
import com.dev.backend.repository.BookingRepository;
import com.dev.backend.repository.RoomRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public Booking bookRoom(BookingDto bookingDto) {
        // Check if room exists
        Room room = roomRepository.findById(bookingDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // Check if room is available
        if (!room.isAvailable()) {
            throw new RuntimeException("Room is not available");
        }

        // Check if room is already booked for the date
        if (bookingRepository.existsByRoomIdAndDate(bookingDto.getRoomId(), bookingDto.getDate())) {
            throw new RuntimeException("Room is already booked for this date");
        }

        // Create booking
        Booking booking = new Booking(bookingDto.getUserId(), bookingDto.getRoomId(), bookingDto.getDate());

        // Mark room as unavailable (simplified - in real app, you might want different
        // logic)
        room.setAvailable(false);
        roomRepository.save(room);

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
