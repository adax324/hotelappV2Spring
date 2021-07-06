package com.hotelservice.hotelapp.service;

import com.hotelservice.hotelapp.bin.Guest;
import com.hotelservice.hotelapp.bin.Room;
import com.hotelservice.hotelapp.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
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
    public List<Room> getAllAvailableRooms(){
        List<Room> rooms=roomRepo.findAll();
        List<Room> availableRooms=new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }
    public Room getById(Integer id){
        return roomRepo.findRoomById(id).orElseThrow(RuntimeException::new);
    }
    public void registerNewRoom(Integer id, List<Guest> guests){
        for (Guest guest : guests) {
            if (Period.between(guest.getBirthDay(), LocalDate.now()).getYears()<18){
                return;
            }
        }

        Room room=roomRepo.getById(id);
        room.setGuests(guests);
        roomRepo.save(room);
        setRoomUnavailable(id);

    }
    public void unregisterRoom(Integer id){
        setRoomUnavailable(id);
    }
    private void setRoomUnavailable(Integer id){
        Room room=this.roomRepo.getById(id);
        room.setAvailable(false);
        roomRepo.save(room);
    }
    private void setRoomAvailable(Integer id){
        Room room=roomRepo.getById(id);
        room.setAvailable(true);
        roomRepo.save(room);

    }


}
