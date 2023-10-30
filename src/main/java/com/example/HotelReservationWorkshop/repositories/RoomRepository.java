package com.example.HotelReservationWorkshop.repositories;

import com.example.HotelReservationWorkshop.dto.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM room r WHERE r.typeRoom = :typeRoom")
    List<Room> getRoomByType(@Param("typeRoom") String typeRoom);

    @Query("SELECT r FROM room r WHERE r.numberRoom NOT IN(SELECT r.room FROM reservation r WHERE r.room IS NOT NULL)")
    List<Room> getRoomByDate(@Param("reservation_date") Date reservation_date);
}
