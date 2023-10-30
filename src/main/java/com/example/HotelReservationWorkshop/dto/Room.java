package com.example.HotelReservationWorkshop.dto;


import jakarta.persistence.*;

@Entity
@Table(name="room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number_room")
    private long numberRoom;

    @Column(name = "type_room")
    private String typeRoom;

    @Column(name = "original_price")
    private double originalPrice;

    public Room() {
    }

    public Room(long numberRoom, String typeRoom, double originalPrice) {
        this.numberRoom = numberRoom;
        this.typeRoom = typeRoom;
        this.originalPrice = originalPrice;
    }

    public long getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(long numberRoom) {
        this.numberRoom = numberRoom;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
}
