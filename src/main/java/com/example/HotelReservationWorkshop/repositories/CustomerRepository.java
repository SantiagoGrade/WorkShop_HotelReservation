package com.example.HotelReservationWorkshop.repositories;

import com.example.HotelReservationWorkshop.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
