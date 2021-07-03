package com.hotelservice.hotelapp.controller;

import com.hotelservice.hotelapp.bin.Room;
import com.hotelservice.hotelapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Room>> getAll(){

    return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id){
    return new ResponseEntity<>(roomService.getById(id),HttpStatus.OK);
    }
}
