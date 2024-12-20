package com.ust.Driver.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class ResponseDto {

    public List<CustomerDto> customerdto;
    public DriverDto driverDto;

    public List<CustomerDto> getCustomerdto() {
        return customerdto;
    }

    public void setCustomerdto(List<CustomerDto> customerdto) {
        this.customerdto = customerdto;
    }

    public DriverDto getDriverDto() {
        return driverDto;
    }

    public void setDriverDto(DriverDto driverDto) {
        this.driverDto = driverDto;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "customerdto=" + customerdto +
                ", driverDto=" + driverDto +
                '}';
    }

    public ResponseDto() {
    }

    public ResponseDto(List<CustomerDto> customerdto, DriverDto driverDto) {
        this.customerdto = customerdto;
        this.driverDto = driverDto;
    }
}
