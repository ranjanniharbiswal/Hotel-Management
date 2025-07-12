package com.dev.backend.controllers;

import com.dev.backend.dto.ApiResponse;
import com.dev.backend.entity.Room;
import com.dev.backend.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/available-rooms")
    public ResponseEntity<ApiResponse> getAllAvailableRooms() {
        try {
            List<Room> rooms = roomService.getAvailableRooms();
            return ResponseEntity.ok(new ApiResponse(true, "Rooms retrieved successfully !!", rooms));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Failed to retrieve available rooms: " + e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllRooms() {
        try {
            List<Room> rooms = roomService.getAllRooms();
            return ResponseEntity.ok(new ApiResponse(true, "All rooms retrieved successfully !!", rooms));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Failed to retrieve rooms: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getRoomById(@PathVariable Long id) {
        try {
            Optional<Room> room = roomService.getRoomById(id);
            if (room.isPresent()) {
                return ResponseEntity.ok(new ApiResponse(true, "Room found !!", room.get()));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ApiResponse(false, "Room not found with ID: " + id));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error retrieving room: " + e.getMessage()));
        }
    }

    @PostMapping("/add-room")
    public ResponseEntity<ApiResponse> addRoom(@RequestBody Room room) {
        try {
            Room savedRoom = roomService.saveRoom(room);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "Room added successfully !!", savedRoom));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse(false, "Failed to add room: " + e.getMessage()));
        }
    }
}
