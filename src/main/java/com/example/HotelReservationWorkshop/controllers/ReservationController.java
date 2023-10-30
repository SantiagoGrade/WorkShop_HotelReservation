package com.example.HotelReservationWorkshop.controllers;

import com.example.HotelReservationWorkshop.dto.Reservation;
import com.example.HotelReservationWorkshop.dto.Room;
import com.example.HotelReservationWorkshop.repositories.CustomerRepository;
import com.example.HotelReservationWorkshop.repositories.RoomRepository;
import com.example.HotelReservationWorkshop.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {
    private ReservationService reservationService;
    private CustomerRepository customerRepository;
    private RoomRepository roomRepository;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/rooms-Available")
    public ResponseEntity<List<Room>> foundRoomsAvailable() {
        List<Room> roomsAvailable = reservationService.searchRoomAvailable();
        return  ResponseEntity.ok(roomsAvailable);
    }

    @GetMapping("/rooms-available-type")
    public ResponseEntity<List<Room>> foundRoomsAvailableType(@RequestParam("type") String type) {
        List<Room> roomsAvailable = reservationService.foundRoomAvailableByType(type);
        return  ResponseEntity.ok(roomsAvailable);
    }

    @GetMapping("/rooms-available-date")
    public ResponseEntity<List<Room>> foundRoomsAvailableDate(@RequestParam("date") Date date) {
        List<Room> roomsAvailable = reservationService.foundRoomAvailableByDate(date);
        return ResponseEntity.ok(roomsAvailable);
    }

    @GetMapping("/register")
    public ResponseEntity<String> createReservation(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                                                    @RequestParam("code") String code, @RequestParam("cedula") Long cedula,
                                                    @RequestParam("numberRoom") Long numberRoom,
                                                    @RequestParam("type") String typeRoom) {

        Reservation newReservation = reservationService.makeAReservation(date,code,cedula,numberRoom,typeRoom);
        return ResponseEntity.ok("Reservation created success");

    }
}
