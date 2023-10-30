package com.example.HotelReservationWorkshop.dto;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date reservation_date;

    @Column
    private String reservationCode;

    @ManyToOne()
    @JoinColumn(name= "cliente_Id")
    private Client client;

    public Reservation() {
    }

    public Reservation(Long id, Date reservation_date, String reservationCode, Client client) {
        this.id = id;
        this.reservation_date = reservation_date;
        this.reservationCode = reservationCode;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
