package com.ust.Booking.Dto;

import java.util.List;

public class ResponseDto {
    private BookingDto booking;
    private List<DriverDto> driver;

    public ResponseDto() {
    }

    public ResponseDto(BookingDto booking, List<DriverDto> driver) {
        this.booking = booking;
        this.driver = driver;
    }

    public BookingDto getBooking() {
        return booking;
    }

    public void setBooking(BookingDto booking) {
        this.booking = booking;
    }

    public List<DriverDto> getDriver() {
        return driver;
    }

    public void setDriver(List<DriverDto> driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "booking=" + booking +
                ", driver=" + driver +
                '}';
    }
}
