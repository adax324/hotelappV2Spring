package com.hotelservice.hotelapp.module.controller.room;

import com.hotelservice.hotelapp.module.entity.room.Room;
import com.hotelservice.hotelapp.module.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {

        return new ResponseEntity<>(roomService.addRoomToRepo(room), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Room>> getAll() {

        return new ResponseEntity<>(roomService.getAllRooms(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(roomService.getById(id), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Room> updateRoomById(@PathVariable("id") Integer id,@RequestBody Room updatedRoom){
        Room room=updatedRoom;
        try {
            return new ResponseEntity<>(roomService.updateRoom(id,updatedRoom),HttpStatus.OK);
        }catch (EmptyResultDataAccessException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRoomById(@PathVariable(name = "id") Integer id) {

        try {
            roomService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(HttpStatus.GONE);
    }
}
