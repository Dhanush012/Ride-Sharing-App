package com.ust.Booking.Service;

import com.ust.Booking.Dto.ResponseDto;
import com.ust.Booking.Model.BookingModel;

public interface BookingService {
    BookingModel addBooking(BookingModel bookingModel);
    ResponseDto getBooking(int bookingNumber);
}
