package com.example.HotelReservationWorkshop.services;


import com.example.HotelReservationWorkshop.dto.Customer;
import com.example.HotelReservationWorkshop.exceptions.InvalidateDate;
import com.example.HotelReservationWorkshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.customerRepository = repository;
    }

    public CustomerService() {
    }

    public Customer registerClient(Customer customer) {
        if(!isNumberCedula(customer.getCedula())) {
            throw new InvalidateDate("The cedula must be of a numerical character")
        }

    }

    private boolean isNumberCedula(Long cedula) {
        String cedulaStr = cedula.toString();
        return cedulaStr.matches("\\d+");
    }
}
