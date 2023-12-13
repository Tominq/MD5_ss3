package dev.ronin.webdemo.entity;

import lombok.Data;

@Data
public class Hotel {
    private String hotelId;
    private String hotelName;
    private String address;
    private String city;
    private String country;
}
