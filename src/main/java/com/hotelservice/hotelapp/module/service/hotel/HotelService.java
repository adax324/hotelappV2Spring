package com.hotelservice.hotelapp.module.service.hotel;

import com.hotelservice.hotelapp.module.entity.hotel.HotelEntity;
import com.hotelservice.hotelapp.module.repository.hotel.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class HotelService {
    private HotelRepo hotelRepo;

    @Autowired
    public HotelService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }
    public HotelEntity addHotel(HotelEntity hotelEntity){
        hotelEntity.setUuid(UUID.randomUUID().toString());
         hotelRepo.save(hotelEntity);
         return hotelEntity;

    }
    public HotelEntity getHotel(String uuid){
        return hotelRepo.getHotelEntityByUuid(uuid).orElse(null);
    }
    public void deleteByUuid(String uuid){
        hotelRepo.deleteByUuid(uuid);

    }
}
