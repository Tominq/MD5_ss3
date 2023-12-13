package dev.ronin.webdemo.dto;

import lombok.Data;

@Data
public class DeleteHotelRequest {
    private String hotelId;
    private String hotelName;
    private String address;
    private String city;
    private String country;
}
