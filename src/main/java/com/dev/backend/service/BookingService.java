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
import com.dev.backend.repository.UserRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public Booking bookRoom(BookingDto bookingDto) {

        // Check if the user exists
        boolean userExists = userRepository.existsById(bookingDto.getUserId());
        if (!userExists) {
            throw new RuntimeException("User not found !!");
        }
        // Check if room exists
        Room room = roomRepository.findById(bookingDto.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found !!"));

        // Check if room is available
        if (!room.isAvailable()) {
            throw new RuntimeException("Room is not available !!");
        }

        // Book Room
        Booking booking = new Booking(bookingDto.getUserId(), bookingDto.getRoomId(), bookingDto.getDate());
        room.setAvailable(false);
        roomRepository.save(room);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
