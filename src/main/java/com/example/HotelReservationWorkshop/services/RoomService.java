package com.example.HotelReservationWorkshop.services;

import com.example.HotelReservationWorkshop.dto.Room;
import com.example.HotelReservationWorkshop.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoomService {
    private RoomRepository repository;

    @Autowired
    public RoomService(RoomRepository repository){
        this.repository = repository;
    }

    public RoomService() {

    }

    public String registerRoom() {

    }

    public boolean registerRoomsStandar() {
        double priceStandar = 70000.0;
        boolean registerRoom = true;

        for (int i = 6; i <= 10; i++) {
            Long idHab = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
            Room premium = new Room(idHab, "Standar", priceStandar);
            if (repository.save(premium) == null) {
                registerRoom = false;
                break;
            }
        }

        return registerRoom;
    }


    public boolean registerRoomsPremium() {
        double pricePremium = 130000.0;
        boolean registerRoom = true;

        for (int i = 1; i <= 5; i++) {
            Long idHab = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
            Room premium = new Room(idHab, "Premium", pricePremium);
            if (repository.save(premium) == null) {
                registerRoom = false;
                break;
            }
        }

        return registerRoom;
    }
}
