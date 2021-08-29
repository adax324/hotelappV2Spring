package com.hotelservice.hotelapp.module.service;

import com.hotelservice.hotelapp.module.entity.Guest;
import com.hotelservice.hotelapp.module.entity.HotelEntity;
import com.hotelservice.hotelapp.module.entity.Room;
import com.hotelservice.hotelapp.module.repository.HotelRepo;
import com.hotelservice.hotelapp.module.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public Room addRoomToRepo(Room room) {
        HotelEntity hotelEntity = hotelRepo.getHotelEntityByUuid(room.getHotel_uuid())
                .orElseThrow(() -> new IllegalArgumentException("Room needs to have hotel!"));
        if (hotelEntity != null) {
            room.setHotelEntity(hotelEntity);
            room.setUuid(UUID.randomUUID().toString());
            roomRepo.save(room);
        }
        return room;
    }


    public List<Room> getAllRooms(String uuid) {
        List<Room> rooms = roomRepo.findAll();
        rooms.stream()
                .filter(room -> room.getHotel_uuid() != null && room.getHotel_uuid().equals(uuid))
                .collect(Collectors.toList());
        return rooms;


    }

    public List<Room> getAllAvailableRooms(String hotelUuid) {
        List<Room> rooms = roomRepo.findAll();
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable() && room.getHotel_uuid().equals(hotelUuid)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Room getById(Integer id) {
        return roomRepo.findRoomById(id).orElseThrow(RuntimeException::new);
    }

    public Room registerNewRoom(String uuid, List<Guest> guests) { //returns true when register is done
        for (Guest guest : guests) {
            if (Period.between(guest.getBirthDay(), LocalDate.now()).getYears() < 18) {
                throw new IllegalArgumentException("there is have to be at leats 18 old");
            }
        }

        Room room = roomRepo.findRoomByUuid(uuid).orElseThrow(() -> new IllegalArgumentException("there is no room with this uuid"));
        room.setGuests(guests);
        roomRepo.save(room);
        setRoomUnavailableOrAvailable(uuid,false);
        return room;

    }

    public void unregisterRoom(String uuid) {
        setRoomUnavailableOrAvailable(uuid, false);
    }

    private void setRoomUnavailableOrAvailable(String uuid, boolean available) {
        Room room = this.roomRepo.findRoomByUuid(uuid)
                .orElseThrow(() -> new IllegalArgumentException("there is no room with this uuid"));
        room.setAvailable(available);
        roomRepo.saveAndFlush(room);
    }


    public Room updateRoom(Integer id, Room updatedRoom) {
        Room room = roomRepo.findRoomById(id).orElse(null);
        if (room != null) {
            return roomRepo.saveAndFlush(room.updateRoom(updatedRoom));
        } else throw new EmptyResultDataAccessException(1);
    }


    public void deleteById(Integer id) {
        roomRepo.deleteById(id);
    }


}
