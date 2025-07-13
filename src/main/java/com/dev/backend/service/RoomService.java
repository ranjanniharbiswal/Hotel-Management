package com.dev.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Room;
import com.dev.backend.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    //Get the details of all rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    
    //Get all available rooms
    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailable(true);
    }
    
    //Get specific room details by room_id
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }
    
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
}
