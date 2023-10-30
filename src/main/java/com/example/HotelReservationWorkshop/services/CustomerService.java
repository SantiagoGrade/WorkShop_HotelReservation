package com.example.HotelReservationWorkshop.services;


import com.example.HotelReservationWorkshop.dto.Customer;
import com.example.HotelReservationWorkshop.exceptions.DuplicateException;
import com.example.HotelReservationWorkshop.exceptions.InvalidateDate;
import com.example.HotelReservationWorkshop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerService() {
    }

    public Customer registerClient(Customer customer) {
        if(!isNumberCedula(customer.getCedula())) {
            throw new InvalidateDate("The cedula must be of a numerical character");
        }
        if(customerRepository.existsById(customer.getCedula())){
            throw new DuplicateException("The cedula is already exist");
        }
        if(customer.getName() == null || customer.getLastName() == null){
            throw new InvalidateDate("Name and surname cannot be empty ");
        }

        return this.customerRepository.save(customer);

    }

    private boolean isNumberCedula(Long cedula) {
        String cedulaStr = cedula.toString();
        return cedulaStr.matches("\\d+");
    }

    private List<Customer> getAll(){
        return customerRepository.findAll();
    }

    private Customer getById(Long cedula) {
        return customerRepository.getById(cedula);
    }
}
