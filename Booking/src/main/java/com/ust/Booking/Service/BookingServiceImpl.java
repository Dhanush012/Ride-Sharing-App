package com.ust.Booking.Service;

import com.ust.Booking.Dto.BookingDto;
import com.ust.Booking.Dto.CustomerDto;
import com.ust.Booking.Dto.DriverDto;
import com.ust.Booking.Dto.ResponseDto;
import com.ust.Booking.Model.BookingModel;
import com.ust.Booking.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingRepo repo;

    @Autowired
    private WebClient.Builder webClientBuilder;



    @Override
    public ResponseDto getBooking(int bookingNumber) {
        ResponseDto responseDto = new ResponseDto();
        BookingModel bookingModel = repo.findByBookingNumber(bookingNumber)
                .orElseThrow(() -> new RuntimeException("Airline not found"));
        BookingDto bookingDto = mapToBooking(bookingModel);

        // Fetch drivers for the booking
        List<DriverDto> driverDTOList = webClientBuilder.baseUrl("http://localhost:9098")
                .build()
                .get()
                .uri("/drivers/withcustomer/" + bookingModel.getBookingNumber())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<DriverDto>>() {})
                .block();

        // Fetch passengers for each flight
        for (DriverDto driverDTO : driverDTOList) {
            List<CustomerDto> customerDTOList = webClientBuilder.baseUrl("http://localhost:9097")
                    .build()
                    .get()
                    .uri("/customer/" + driverDTO.getVehcileNumber())
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<CustomerDto>>() {})
                    .block();

            driverDTO.setCustomerDto(customerDTOList);
        }

        responseDto.setBooking(bookingDto);
        responseDto.setDriver(driverDTOList);

        return responseDto;
    }

    private BookingDto mapToBooking(BookingModel booking) {
        BookingDto dto = new BookingDto();
        dto.setBookingId(booking.getBookingId());
        dto.setBookingNumber(booking.getBookingNumber());
        dto.setFare(booking.getFare());
        dto.setStatus(booking.getStatus());
        return dto;
    }


    @Override
    public BookingModel addBooking(BookingModel bookingModel) {
        return repo.save(bookingModel);
    }


}
