package com.nicorego.nhs.pocapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class HospitalSpecialtyId implements Serializable {

    @Column(name = "hospital_id")
    private Integer hospitalId;

    @Column(name = "specialty_id")
    private Integer specialtyId;

}