package com.hotelservice.hotelapp.module.entity.room;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hotelservice.hotelapp.module.entity.hotel.HotelEntity;
import com.hotelservice.hotelapp.module.entity.guest.Guest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "rooms")
@JsonIgnoreProperties({"hotelEntity"})
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer id;
    private int howManyPersons;
    private boolean toiletIncluded;
    private boolean isAvailable;
   @OneToMany(mappedBy = "roomy")
    private List<Guest> guests;
    private boolean isClean;
    private LocalDate dateOfRegister;
   private LocalDate dateOfUnregister;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;
    private String hotel_uuid;

    public Room updateRoom(Room room){
        this.howManyPersons=room.getHowManyPersons();
        this.toiletIncluded=room.isToiletIncluded();
        this.isAvailable=room.isAvailable();
        this.guests=room.guests;
        this.isClean=room.isClean();
        this.dateOfRegister=room.getDateOfRegister();
        this.dateOfUnregister=room.getDateOfUnregister();
        this.hotelEntity=room.getHotelEntity();
        this.hotel_uuid=room.getHotel_uuid();
        return this;
    }

}
