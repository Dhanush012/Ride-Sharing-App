package com.ust.Driver.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Driver {

    @Id
    public int driverId;
    public String driverName;
    public String vehicleType;
    public int licenseNumber;
    public int bookingNumber;
    public int vehcileNumber;

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getVehcileNumber() {
        return vehcileNumber;
    }

    public void setVehcileNumber(int vehcileNumber) {
        this.vehcileNumber = vehcileNumber;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Driver() {
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Driver(int driverId, String driverName, String vehicleType, int licenseNumber, int bookingNumber, int vehcileNumber) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehicleType = vehicleType;
        this.licenseNumber = licenseNumber;
        this.bookingNumber = bookingNumber;
        this.vehcileNumber = vehcileNumber;
    }


    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", driverName='" + driverName + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", licenseNumber=" + licenseNumber +
                ", bookingNumber=" + bookingNumber +
                ", vehcileNumber=" + vehcileNumber +
                '}';
    }
}
