package com.ust.Booking.Controller;

import com.ust.Booking.Dto.ResponseDto;
import com.ust.Booking.Model.BookingModel;
import com.ust.Booking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    public BookingService service;

    @PostMapping("/addbooking")
    public ResponseEntity<BookingModel> addBooking(@RequestBody BookingModel bookingModel)
    {
        return ResponseEntity.ok(service.addBooking(bookingModel));
    }
    @GetMapping("{bookingNumber}")
    public ResponseEntity<ResponseDto> getCustomer(@PathVariable("bookingNumber")int bookingNumber)
    {
        ResponseDto responseDto=service.getBooking(bookingNumber);
        return ResponseEntity.ok(responseDto);
    }

}
