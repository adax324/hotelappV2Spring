package com.hotelservice.hotelapp.repo;

import com.hotelservice.hotelapp.bin.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room,Integer> {
    Optional<Room> findRoomById(Integer id);
}
