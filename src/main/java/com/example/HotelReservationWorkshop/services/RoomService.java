package com.example.HotelReservationWorkshop.services;

import com.example.HotelReservationWorkshop.dto.Room;
import com.example.HotelReservationWorkshop.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        registerRoomsPremium();
        registerRoomsStandar();
        return "Room registered correctly";

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

    public List<Room> getRooms() {
        return repository.findAll();
    }

    public void deleteRoom(Room room){
        repository.delete(room);
    }

    public Room createRoom(Room room) {
        return repository.save(room);
    }

    public List<Room> getRoomByType(String type) {
        return repository.getRoomByType(type);
    }


}
