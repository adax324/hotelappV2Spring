package com.hotelservice.hotelapp.repo;

import com.hotelservice.hotelapp.bin.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Integer> {
    public Hotel getHotelById(Integer id);
    }

