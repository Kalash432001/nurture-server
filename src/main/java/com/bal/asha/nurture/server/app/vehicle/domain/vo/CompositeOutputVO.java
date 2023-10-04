package com.bal.asha.nurture.server.app.vehicle.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CompositeOutputVO {

    private int id;
    private String type;
    private String modelCode;
    private String brandName;
    private LocalDate launchDate;
    private String insuredBy;
    private LocalDate insuredOn;

}
