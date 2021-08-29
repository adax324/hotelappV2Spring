package com.hotelservice.hotelapp.module.controller;

import com.hotelservice.hotelapp.module.entity.Guest;
import com.hotelservice.hotelapp.module.entity.Room;
import com.hotelservice.hotelapp.module.entity.UserEntity;
import com.hotelservice.hotelapp.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {
    private UserEntity user;
    private UserService userService;

    @Autowired
    public UserServiceController(UserService userService) {
        this.userService = userService;

    }

    @PutMapping("/registerroom/{uuid}")
    public ResponseEntity<Room> registeruser(@PathVariable(name = "uuid") String uuid, @RequestBody List<Guest> guests){

        return new ResponseEntity<>(userService.registerNewUserToRoom(uuid,guests),HttpStatus.OK);
    }
    @PutMapping("/unregisterroom/{uuid}")
    public ResponseEntity<?> unregisterUser(@PathVariable(name = "uuid") String uuid){
        userService.unregisterUserFromRoom(uuid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
