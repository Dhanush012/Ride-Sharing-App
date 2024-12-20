package com.ust.Booking.Repository;

import com.ust.Booking.Model.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BookingRepo extends JpaRepository<BookingModel,Integer> {
    Optional<BookingModel> findByBookingNumber(int bookingNumber);
}
