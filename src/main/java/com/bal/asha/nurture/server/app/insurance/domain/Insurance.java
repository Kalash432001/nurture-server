package com.bal.asha.nurture.server.app.insurance.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
public class Insurance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "type", nullable = false)
    private String type;
    private String insuredBy;
    private LocalDate insuredOn;
    private transient String formattedDate;

    private String startsOn;
    private String coverPlasticItems;
    private String coverGlassItems;
    private String coverInteriorItems;
    private String cost;
    private String expiry;
    private String name;

}
