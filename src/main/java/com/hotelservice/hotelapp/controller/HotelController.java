package com.hotelservice.hotelapp.controller;

import com.hotelservice.hotelapp.bin.Hotel;
import com.hotelservice.hotelapp.bin.Room;
import com.hotelservice.hotelapp.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/hotel")
@RestController
public class HotelController {
    private HotelService hotelService;
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @PostMapping("/add")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        Hotel hotel1=hotelService.addHotel(hotel);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable(name = "id") Integer id){
        return new ResponseEntity<>(hotelService.getHotel(id),HttpStatus.OK);
    }
}
