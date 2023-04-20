package com.nicorego.nhs.pocapi.repository;

import com.nicorego.nhs.pocapi.model.HospitalSpecialty;
import com.nicorego.nhs.pocapi.model.HospitalSpecialtyId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalSpecialtyRepository extends CrudRepository<HospitalSpecialty, HospitalSpecialtyId> {
}