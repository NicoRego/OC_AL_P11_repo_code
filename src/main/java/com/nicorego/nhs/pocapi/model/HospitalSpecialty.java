package com.nicorego.nhs.pocapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "hospital_specialty")
public class HospitalSpecialty {

    @EmbeddedId
    private HospitalSpecialtyId id;

    @ManyToOne
    @MapsId("hospitalId")
    private Hospital hospital;

    @ManyToOne
    @MapsId("specialtyId")
    private Specialty specialty;

}