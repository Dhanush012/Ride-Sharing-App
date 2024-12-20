package com.ust.Booking.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class BookingModel {
    @Id
    public int bookingId;
    public String status;
    public int fare;
    public int bookingNumber;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "bookingModel{" +
                "bookingId=" + bookingId +
                ", status='" + status + '\'' +
                ", fare=" + fare +
                ", bookingNumber=" + bookingNumber +
                '}';
    }

    public BookingModel() {
    }

    public BookingModel(int bookingId, String status, int fare, int bookingNumber) {
        this.bookingId = bookingId;
        this.status = status;
        this.fare = fare;
        this.bookingNumber = bookingNumber;
    }
}
