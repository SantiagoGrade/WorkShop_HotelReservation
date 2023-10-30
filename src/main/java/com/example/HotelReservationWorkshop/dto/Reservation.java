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
    private Customer customer;

    public Reservation() {
    }

    public Reservation(Long id, Date reservation_date, String reservationCode, Customer customer) {
        this.id = id;
        this.reservation_date = reservation_date;
        this.reservationCode = reservationCode;
        this.customer = customer;
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

    public Customer getClient() {
        return customer;
    }

    public void setClient(Customer customer) {
        this.customer = customer;
    }
}
