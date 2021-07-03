package com.hotelservice.hotelapp.service;

import com.hotelservice.hotelapp.bin.Room;
import com.hotelservice.hotelapp.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomService {
    private RoomRepo roomRepo;


    @Autowired
    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }
    public void addRoomToRepo(Room room){
        roomRepo.save(room);
    }


    public List<Room> getAllRooms(){
        return roomRepo.findAll();
    }

    public Room getById(Integer id){
        return roomRepo.findRoomById(id).orElseThrow(RuntimeException::new);
    }

}
