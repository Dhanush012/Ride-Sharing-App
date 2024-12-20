package com.ust.customer.Service;

import com.ust.customer.Controller.CustomerController;
import com.ust.customer.Model.Customer;
import com.ust.customer.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public Customer addCustomer(Customer customer){
        return repo.save(customer);
    }

    public List<Customer> getAllCustomer(int vehicleNumber){
        return repo.findByVehicleNumber(vehicleNumber);
    }

}
