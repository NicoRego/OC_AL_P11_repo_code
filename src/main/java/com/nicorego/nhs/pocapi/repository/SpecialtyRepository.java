package com.nicorego.nhs.pocapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.nicorego.nhs.pocapi.model.Specialty;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends CrudRepository<Specialty, Integer>{

}
