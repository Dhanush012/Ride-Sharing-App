package com.ust.Booking.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class DriverDto {

    public int driverId;
    public String driverName;
    public String vehicleType;
    public int licenseNumber;
    public int vehcileNumber;
    public int bookingNumber;
    public List<CustomerDto> customerDto;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getVehcileNumber() {
        return vehcileNumber;
    }

    public void setVehcileNumber(int vehcileNumber) {
        this.vehcileNumber = vehcileNumber;
    }

    public List<CustomerDto> getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(List<CustomerDto> customerDto) {
        this.customerDto = customerDto;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public DriverDto() {
    }

    @Override
    public String toString() {
        return "DriverDto{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", licenseNumber=" + licenseNumber +
                ", vehcileNumber=" + vehcileNumber +
                ", bookingNumber=" + bookingNumber +
                ", customerDto=" + customerDto +
                '}';
    }

    public DriverDto(int driverId, String driverName, String vehicleType, int licenseNumber, int vehcileNumber, int bookingNumber, List<CustomerDto> customerDto) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehicleType = vehicleType;
        this.licenseNumber = licenseNumber;
        this.vehcileNumber = vehcileNumber;
        this.bookingNumber = bookingNumber;
        this.customerDto = customerDto;
    }
}

