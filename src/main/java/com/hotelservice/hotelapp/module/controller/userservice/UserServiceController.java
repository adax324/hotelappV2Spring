package com.hotelservice.hotelapp.module.controller.userservice;

import com.hotelservice.hotelapp.module.entity.guest.Guest;
import com.hotelservice.hotelapp.module.entity.room.Room;
import com.hotelservice.hotelapp.module.service.hotel.HotelService;
import com.hotelservice.hotelapp.module.service.room.RoomService;
import com.hotelservice.hotelapp.module.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {
    private UserService userService;

    @Autowired
    public UserServiceController(UserService userService) {
        this.userService = userService;

    }

    @PutMapping("/registerroom/{id}")
    public ResponseEntity<Room> registeruser(@PathVariable(name = "id") Integer id, @RequestBody List<Guest> guests){
        userService.registerNewUserToRoom(id,guests);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/unregisterroom/{id}")
    public ResponseEntity<?> unregisterUser(@PathVariable(name = "id") Integer id){
        userService.unregisterUserFromRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
