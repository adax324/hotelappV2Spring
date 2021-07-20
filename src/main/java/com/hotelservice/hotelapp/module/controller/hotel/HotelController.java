package com.hotelservice.hotelapp.module.controller.hotel;

import com.hotelservice.hotelapp.module.entity.hotel.HotelEntity;
import com.hotelservice.hotelapp.module.service.hotel.HotelService;
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
    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<?> deleteHotel(@PathVariable(name = "uuid") String uuid){
        hotelService.deleteByUuid(uuid);
        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
