package dev.ronin.webdemo.dto;

import lombok.Data;

@Data
public class UpdateHotelRequest {
    private String hotelName;
    private String address;
    private String city;
    private String country;
}
