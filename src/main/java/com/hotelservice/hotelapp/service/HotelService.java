package com.hotelservice.hotelapp.service;

import com.hotelservice.hotelapp.bin.Guest;
import com.hotelservice.hotelapp.bin.Hotel;
import com.hotelservice.hotelapp.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private HotelRepo hotelRepo;

    @Autowired
    public HotelService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }
    public Hotel addHotel(Hotel hotel){
         hotelRepo.save(hotel);
         return hotel;

    }
    public Hotel getHotel(Integer id){
        return hotelRepo.getHotelById(id);
    }
    public void deleteHotelById(Integer id){
        hotelRepo.deleteById(id);
    }
}
