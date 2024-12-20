package com.ust.customer.Controller;


import com.ust.customer.Model.Customer;
import com.ust.customer.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/addcustomer")
    public Customer addcustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @GetMapping("{vehicleNumber}")
    public List<Customer> getAllCustomer(@PathVariable int vehicleNumber){
        return service.getAllCustomer(vehicleNumber);
    }

}
