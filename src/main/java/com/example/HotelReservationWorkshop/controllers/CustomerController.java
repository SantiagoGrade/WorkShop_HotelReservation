package com.example.HotelReservationWorkshop.controllers;


import com.example.HotelReservationWorkshop.dto.Customer;
import com.example.HotelReservationWorkshop.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        this.customerService.registerClient(customer);
        return  ResponseEntity.ok(customer);
    }

    @GetMapping("/show")
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customers = this.customerService.obtainAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
