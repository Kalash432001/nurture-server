package com.bal.asha.nurture.server.app.vehicle.domain;


import com.bal.asha.nurture.server.common.domain.DomainAggregateRoot;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Setter
@EqualsAndHashCode
@Entity
@ToString
public class Vehicle extends DomainAggregateRoot {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VehicleId")
    @SequenceGenerator(name = "VehicleId", sequenceName = "VEHICLE_SEQ", initialValue = 500)
    private Long id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "model_code", nullable = false)
    private String modelCode;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "launch_date")
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

    public static Vehicle create(String type, String modelCode, String brandName, LocalDate date) {
        Vehicle o = new Vehicle();
        o.modelCode = modelCode;
        o.brandName = brandName;
        o.launchDate = date;
        o.type = type;
        return o;
    }

}
