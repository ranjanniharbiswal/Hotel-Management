package com.dev.backend.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dev.backend.entity.Room;
import com.dev.backend.repository.RoomRepository;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private RoomRepository roomRepository;
    
    @Override
    public void run(String... args) throws Exception {
        

        //Here, U can add rooms manually .. !
        if (roomRepository.count() == 0) {
            roomRepository.save(new Room("101", "Single", new BigDecimal("100.00")));
            roomRepository.save(new Room("102", "Double", new BigDecimal("150.00")));
            roomRepository.save(new Room("103", "Single", new BigDecimal("100.00")));
            roomRepository.save(new Room("201", "Double", new BigDecimal("160.00")));
            roomRepository.save(new Room("202", "Double", new BigDecimal("250.00")));
        }
    }
}
