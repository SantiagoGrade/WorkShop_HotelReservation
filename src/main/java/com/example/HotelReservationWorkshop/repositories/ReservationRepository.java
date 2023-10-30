package com.example.HotelReservationWorkshop.repositories;

import com.example.HotelReservationWorkshop.dto.Reservation;
import com.example.HotelReservationWorkshop.dto.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findBYreservation_date(LocalDate reservation_date);

}
