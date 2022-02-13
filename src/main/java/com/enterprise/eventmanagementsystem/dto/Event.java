package com.enterprise.eventmanagementsystem.dto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Event")
public @Data
class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "MM/dd/yyyy")
    @Column(name = "date")
    private Date date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME, pattern = "hh:mm a")
    @Column(name = "time")
    private Date time;

    @Column(name = "description")
    private String description;
}