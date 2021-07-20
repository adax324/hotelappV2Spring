package com.hotelservice.hotelapp.module.repository.room;

import com.hotelservice.hotelapp.module.entity.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {
    Optional<Room> findRoomById(Integer id);
    void deleteById(Integer id);
}
