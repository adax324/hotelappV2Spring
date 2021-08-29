package com.hotelservice.hotelapp.module.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "hotel")

public class HotelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Integer id;
    @OneToMany(mappedBy = "hotelEntity")
    private List<Room> rooms;
    @Column(unique = true)
    private String uuid;


}
