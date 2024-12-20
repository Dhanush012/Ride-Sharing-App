package com.ust.customer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    public int customerId;
    public String customerName;
    public String pickupLocation;
    public String dropLocation;
    public int vehicleNumber;

}
