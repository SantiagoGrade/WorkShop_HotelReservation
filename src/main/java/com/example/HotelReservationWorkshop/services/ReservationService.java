package com.example.HotelReservationWorkshop.services;

import com.example.HotelReservationWorkshop.dto.Customer;
import com.example.HotelReservationWorkshop.dto.Reservation;
import com.example.HotelReservationWorkshop.dto.Room;
import com.example.HotelReservationWorkshop.exceptions.InvalidateDate;
import com.example.HotelReservationWorkshop.repositories.CustomerRepository;
import com.example.HotelReservationWorkshop.repositories.ReservationRepository;
import com.example.HotelReservationWorkshop.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public ReservationService(CustomerRepository customerRepository, RoomRepository roomRepository, ReservationRepository reservationRepository){
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
    }

    public double calculateTotalPrice(Room room) {
        double originalPrice = room.getOriginalPrice();
        String type = room.getTypeRoom();
        if (type.equalsIgnoreCase("Standar")) {
            double discount = originalPrice * 0.2;
            return originalPrice - discount;
        } else {
            double discount = originalPrice * 0.25;
            return originalPrice - discount;
        }
    }

    public Reservation makeAReservation(Date date, String id, Long cedula, Long codeRoom, String typeRoom){
        Random random = new Random();
        Long reservationID = random.nextLong();
        Customer customer = customerRepository.findById(cedula)
                .orElseThrow(()-> new InvalidateDate("Customer no found with the cedula " + cedula));
        Room room = roomRepository.findById(codeRoom)
                .orElseThrow(()-> new InvalidateDate("Room not found with ID " + codeRoom));
        double price = calculateTotalPrice(room);
        Reservation reservation = new Reservation(reservationID,date,id,customer,room,price);
        return reservationRepository.save(reservation);
    }

    public List<Reservation> viewReservation(long cedula) {
        List<Reservation> listOfAllReservations = reservationRepository.findAll();
        if(listOfAllReservations.isEmpty()) {
            throw new InvalidateDate("The customer with cedula " + cedula + " has not made a reservation");
        }
        return listOfAllReservations.stream()
                .filter((reservation -> reservation.getClient().getCedula() == cedula))
                .collect(Collectors.toList());
    }

    public List<Room> searchRoomAvailable() {
        return roomRepository.findAll();

    }

    public List<Reservation> viewAllReservations() {
        List<Reservation> list = reservationRepository.findAll();
        return  list;
    }

    public List<Room> foundRoomAvailableByType(String type) {
        return roomRepository.getRoomByType(type);
    }

    public List<Room> foundRoomAvailableByDate(Date reservationDate) {
        return roomRepository.getRoomByDate(reservationDate);
    }


}
