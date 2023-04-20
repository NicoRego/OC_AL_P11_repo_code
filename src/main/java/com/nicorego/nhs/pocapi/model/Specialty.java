package com.nicorego.nhs.pocapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Getter
@Setter
@DynamicUpdate
@Table(name = "specialty")
public class Specialty implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name")
	private String name;

}