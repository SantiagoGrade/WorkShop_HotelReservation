package com.example.HotelReservationWorkshop.controllers;

import com.example.HotelReservationWorkshop.dto.Room;
import com.example.HotelReservationWorkshop.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private RoomService service;

    @Autowired
    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerRoom() {
        this.service.registerRoom();
        return ResponseEntity.ok("room register success");
    }

    public ResponseEntity<List<Room>> getRooms() {
        List<Room> rooms = this.service.getRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
