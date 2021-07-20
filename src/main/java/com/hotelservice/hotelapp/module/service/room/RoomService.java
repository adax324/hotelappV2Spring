package com.hotelservice.hotelapp.module.service.room;

import com.hotelservice.hotelapp.module.entity.guest.Guest;
import com.hotelservice.hotelapp.module.entity.hotel.HotelEntity;
import com.hotelservice.hotelapp.module.entity.room.Room;
import com.hotelservice.hotelapp.module.repository.hotel.HotelRepo;
import com.hotelservice.hotelapp.module.repository.room.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoomService {
    private RoomRepo roomRepo;
    private HotelRepo hotelRepo;


    @Autowired
    public RoomService(RoomRepo roomRepo, HotelRepo hotelRepo) {
        this.roomRepo = roomRepo;
        this.hotelRepo = hotelRepo;
    }
    public Room addRoomToRepo(Room room){
        HotelEntity hotelEntity=hotelRepo.getHotelEntityByUuid(room.getHotel_uuid()).orElse(null);
        if (hotelEntity!=null){
            room.setHotelEntity(hotelEntity);
            roomRepo.save(room);
        }
        return room;
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
    public Room updateRoom(Integer id, Room updatedRoom) {
        Room room=roomRepo.findRoomById(id).orElse(null);
        if (room!=null){
            return roomRepo.saveAndFlush(room.updateRoom(updatedRoom));
        } else throw new EmptyResultDataAccessException(1);
    }


    public void deleteById(Integer id) {
        roomRepo.deleteById(id);
    }



}
