package com.hotelservice.hotelapp.bin;

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
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "HMP")
    private int howManyPersons;
    private boolean toiletIncluded;
    private boolean isAvailable;
   @OneToMany(mappedBy = "room")
    private List<Guest> guests;
    private boolean isClean;
    private LocalDate dateOfRegister;
   private LocalDate dateOfUnregister;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;



    public Room(int howManyPersons, boolean toiletIncluded, boolean isAvailable, boolean isClean, Hotel hotel) {
        this.howManyPersons = howManyPersons;
        this.toiletIncluded = toiletIncluded;
        this.isAvailable = isAvailable;
        this.isClean = isClean;
        this.hotel = hotel;
    }
}
