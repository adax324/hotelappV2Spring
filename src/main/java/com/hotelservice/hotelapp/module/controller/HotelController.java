package com.hotelservice.hotelapp.module.controller;

import com.hotelservice.hotelapp.module.entity.HotelEntity;
import com.hotelservice.hotelapp.module.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hotel")
@RestController
public class HotelController {
    private HotelService hotelService;
    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    @PostMapping("/add")
    public ResponseEntity<HotelEntity> addHotel(@RequestBody HotelEntity hotelEntity){
        HotelEntity hotelEntity1 =hotelService.addHotel(hotelEntity);
        return new ResponseEntity<>(hotelEntity, HttpStatus.CREATED);
    }
    @GetMapping("/get/{uuid}")
    public ResponseEntity<HotelEntity> getHotel(@PathVariable(name = "uuid") String uuid){
        if(hotelService.getHotel(uuid)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotelService.getHotel(uuid),HttpStatus.OK);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<HotelEntity>> getAll(){
        return new ResponseEntity<>(hotelService.getAllHotels(),HttpStatus.FOUND);
    }
    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<?> deleteHotel(@PathVariable(name = "uuid") String uuid){
        hotelService.deleteByUuid(uuid);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
