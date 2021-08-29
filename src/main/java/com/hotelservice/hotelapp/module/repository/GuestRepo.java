package com.hotelservice.hotelapp.module.repository;

import com.hotelservice.hotelapp.module.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepo extends JpaRepository<Guest,Integer> {
}
