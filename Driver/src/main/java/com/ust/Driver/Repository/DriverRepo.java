package com.ust.Driver.Repository;

import com.ust.Driver.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Integer> {

    Optional<Driver> findByVehcileNumber(int vehcileNumber);

    List<Driver> findByBookingNumber(int bookingNumber);
}
