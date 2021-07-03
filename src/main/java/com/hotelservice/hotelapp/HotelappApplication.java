package com.hotelservice.hotelapp;

import com.hotelservice.hotelapp.bin.Hotel;
import com.hotelservice.hotelapp.bin.Room;
import com.hotelservice.hotelapp.controller.RoomController;
import com.hotelservice.hotelapp.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HotelappApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


	}
}
