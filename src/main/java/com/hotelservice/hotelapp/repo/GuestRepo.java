package com.hotelservice.hotelapp.repo;

import com.hotelservice.hotelapp.bin.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepo extends JpaRepository<Guest,Integer> {
}
