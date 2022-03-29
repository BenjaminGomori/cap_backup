package com.enterprise.eventmanagementsystem.dto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * This is our Model Layer. This class is used to represent data that could be saved to a database.
 * Each instance corresponds to a row in the table stored in the database.
 * Name, address, city, state, and country, date & time, and description are all stored in the event table.
 * @author Ali Ibrahim, Benjamin Gomori, Kevin Zhu, and Son Bo
 */
@Entity
@Table(name = "event")
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

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

}