package com.hotelservice.hotelapp.module.service.userservice;

import com.hotelservice.hotelapp.module.entity.guest.Guest;
import com.hotelservice.hotelapp.module.entity.room.Room;
import com.hotelservice.hotelapp.module.service.room.RoomService;
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


    public void registerNewUserToRoom(Integer id, List<Guest> guests){
        roomService.registerNewRoom(id,guests);
    }
    public void unregisterUserFromRoom(Integer id){
        roomService.unregisterRoom(id);
    }
}
