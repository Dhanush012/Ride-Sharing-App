package com.ust.Driver.Service;

import com.ust.Driver.Dto.CustomerDto;
import com.ust.Driver.Dto.DriverDto;
import com.ust.Driver.Dto.ResponseDto;
import com.ust.Driver.Model.Driver;
import com.ust.Driver.Repository.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private WebClient webclient;

    public Driver addDriver(Driver driver){
        return repo.save(driver);
    }

    @CircuitBreaker(name = "driverService", fallbackMethod = "fallbackGetBooking")
    public ResponseDto getBooking(int VehicleNumber) {
        ResponseDto responseDto = new ResponseDto();
        Driver driver = repo.findByVehcileNumber(VehicleNumber).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        DriverDto driverDto = mapToDriverDto(driver);

        List<CustomerDto> customerdtolist = webclient.get()
                .uri("http://localhost:9097/customer/" + driver.getVehcileNumber())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CustomerDto>>() {
                })
                .block();

        responseDto.setDriverDto(driverDto);
        responseDto.setCustomerdto(customerdtolist);

        return responseDto;
    }
    public ResponseDto fallbackGetBooking(String VehcileNumber, Throwable throwable) {
        // Handle the fallback logic, e.g., return a default response or log the error
        return new ResponseDto(); // Return an empty response or a default response
    }


    private DriverDto mapToDriverDto(Driver driver) {
        DriverDto driverdto = new DriverDto();
        driverdto.setDriverId(driver.getDriverId());
        driverdto.setDriverName(driver.getDriverName());
        driverdto.setVehicleType(driver.getVehicleType());
        driverdto.setLicenseNumber(driver.getLicenseNumber());
        driverdto.setVehcileNumber(driver.getVehcileNumber());

        return driverdto;
    }

    public List<Driver> getDriversByBooking(int bookingNumber) {
        return repo.findByBookingNumber(bookingNumber);
    }
}
