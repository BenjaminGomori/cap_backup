package com.enterprise.eventmanagementsystem.dto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

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

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date")
    private int date;

    @Column(name = "time")
    private int time;

    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address + " " + city + ", " + state + " " + country;

    }
    public void setAddress(String address) {
        this.address = address;
    }


    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}