package com.ust.Driver.Controller;

import com.ust.Driver.Dto.ResponseDto;
import com.ust.Driver.Model.Driver;
import com.ust.Driver.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping("/addDriver")
    public Driver addDriver(@RequestBody Driver driver){
        return service.addDriver(driver);
    }

    @GetMapping("withcustomer/{vehicleNumber}")
    public ResponseEntity<ResponseDto> getCustomer(@PathVariable("vehicleNumber") int vehicleNumber){
        ResponseDto responseDto = service.getBooking(vehicleNumber);
        return ResponseEntity.ok(responseDto);
    }
}
