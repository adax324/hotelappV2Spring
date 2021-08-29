package com.hotelservice.hotelapp.module.service;

import com.hotelservice.hotelapp.module.entity.Guest;
import com.hotelservice.hotelapp.module.entity.Room;
import com.hotelservice.hotelapp.module.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private RoomService roomService;
    @Autowired
    public UserService(RoomService roomService) {
        this.roomService = roomService;
    }


    public Room registerNewUserToRoom(String uuid, List<Guest> guests){
       return roomService.registerNewRoom(uuid,guests);
    }
    public void unregisterUserFromRoom(String uuid){
        roomService.unregisterRoom(uuid);
    }
}
