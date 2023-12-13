package dev.ronin.webdemo.controller;

import dev.ronin.webdemo.dto.CreateHotelRequest;
import dev.ronin.webdemo.dto.UpdateHotelRequest;
import dev.ronin.webdemo.entity.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HotelController {
    private static List<Hotel> hotelList = new ArrayList<>();

    @PostMapping("/hotels")
    public Hotel createHotel(@RequestBody CreateHotelRequest request) {
        Hotel hotel = new Hotel();
        hotel.setHotelId(request.getHotelId());
        hotel.setHotelName(request.getHotelName());
        hotelList.add(hotel);
        return hotel;
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return hotelList;
    }

    @GetMapping("/hotels/{hotelId}")
    public Hotel getHotelById(@PathVariable String hotelId) {
        return findHotelById(hotelId);
    }

    @PutMapping("/hotels/{hotelId}")
    public Hotel updateHotelById(@PathVariable String hotelId,
                                 @RequestBody UpdateHotelRequest request) {
        Hotel hotel = findHotelById(hotelId);
        if (hotel == null) {
            return null;
        }
        hotel.setHotelName(request.getHotelName());
        return hotel;
    }

    @DeleteMapping("/hotels/{hotelId}")
    public boolean deleteHotelById(@PathVariable String hotelId) {
        Hotel hotel = findHotelById(hotelId);
        if (hotel == null) {
            return false;
        }
        hotelList.remove(hotel);
        return true;
    }

    @GetMapping("/hotels/search")
    public List<Hotel> searchHotels(@RequestParam(value = "keyword") String keyword) {
        List<Hotel> matchingHotels = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().contains(keyword)) {
                matchingHotels.add(hotel);
            }
        }
        return matchingHotels;
    }

    @GetMapping("/hotels/city/{city}")
    public List<Hotel> getHotelsByCity(@PathVariable String city) {
        List<Hotel> matchingHotels = new ArrayList<>();
        for (Hotel hotel : hotelList) {
            if (hotel.getCity().equalsIgnoreCase(city)) {
                matchingHotels.add(hotel);
            }
        }
        return matchingHotels;
    }

    private Hotel findHotelById(String hotelId) {
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelId().equalsIgnoreCase(hotelId)) {
                return hotel;
            }
        }
        return null;
    }
}