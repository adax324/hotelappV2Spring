package com.hotelservice.hotelapp.bin;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
