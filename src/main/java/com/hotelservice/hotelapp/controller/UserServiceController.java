package com.hotelservice.hotelapp.controller;

import com.hotelservice.hotelapp.bin.Room;
import com.hotelservice.hotelapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserServiceController {
    private UserService userService;
    @Autowired
    public UserServiceController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getAvailableRooms")
    public ResponseEntity<List<Room>> getAllRooms(){
        return new ResponseEntity<>(userService.getAvailableRooms(), HttpStatus.OK);
    }
}
