package com.bal.asha.nurture.server.app.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {

    private int id;
    private String type;
    private String modelCode;
    private String brandName;
    private LocalDate launchDate;
    private String name;
    private String color;
    private String seats;
    private String capacity;
    private String engine;
    private String power;
    private String mileage;
    private String maxSpeed;
    private String soundSystem;
    private String ownerName;
    private String insuranceId;
    private String showroomPrice;
    private String onRoadPrice;
    private String unknown5;

}
