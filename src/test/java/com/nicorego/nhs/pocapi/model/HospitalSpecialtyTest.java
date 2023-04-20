package com.nicorego.nhs.pocapi.model;

import com.nicorego.nhs.pocapi.repository.HospitalRepository;
import com.nicorego.nhs.pocapi.repository.HospitalSpecialtyRepository;
import com.nicorego.nhs.pocapi.repository.SpecialtyRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class HospitalSpecialtyTest {

    @MockBean
    private final HospitalRepository hospitalRepository;
    @MockBean
    private final SpecialtyRepository specialtyRepository;
    @MockBean
    private final HospitalSpecialtyRepository hospitalSpecialtyRepository;


    Hospital hospital1 = new Hospital();
    Hospital hospital2 = new Hospital();
    Hospital hospital3 = new Hospital();
    Hospital hospital4 = new Hospital();
    Hospital hospital5 = new Hospital();
    Hospital hospital6 = new Hospital();

    Specialty specialty1 = new Specialty();
    Specialty specialty2 = new Specialty();
    Specialty specialty3 = new Specialty();
    Specialty specialty4 = new Specialty();
    Specialty specialty5 = new Specialty();

    HospitalSpecialty hospitalSpecialty1 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty2 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty3 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty4 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty5 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty6 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty7 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty8 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty9 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty10 = new HospitalSpecialty();
    HospitalSpecialty hospitalSpecialty11 = new HospitalSpecialty();

    HospitalSpecialtyId hsid1 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid2 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid3 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid4 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid5 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid6 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid7 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid8 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid9 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid10 = new HospitalSpecialtyId();
    HospitalSpecialtyId hsid11 = new HospitalSpecialtyId();

    List<Hospital> hospitals = new ArrayList<>();
    List<Specialty> specialties = new ArrayList<>();
    List<HospitalSpecialty> hospitalsSpecialties = new ArrayList<>();

    @Autowired
    public HospitalSpecialtyTest(HospitalRepository hospitalRepository, SpecialtyRepository specialtyRepository, HospitalSpecialtyRepository hospitalSpecialtyRepository) {
        this.hospitalRepository = hospitalRepository;
        this.specialtyRepository = specialtyRepository;
        this.hospitalSpecialtyRepository = hospitalSpecialtyRepository;
    }

    @BeforeEach
    public void setup() {
        hospital1.setId(1);
        hospital1.setName("Hopital Saint Vincent de Paul");
        hospital1.setLatitude(50.620312);
        hospital1.setLongitude(3.077438);
        hospital1.setFreeBeds(2);
        hospital1.setContextMessage(null);

        hospital2.setId(2);
        hospital2.setName("Centre Hospitalier Universitaire de Lille");
        hospital2.setLatitude(50.610937);
        hospital2.setLongitude(3.034687);
        hospital2.setFreeBeds(0);
        hospital2.setContextMessage(null);

        hospital3.setId(3);
        hospital3.setName("Hopital prive La Louviere");
        hospital3.setLatitude(50.646438);
        hospital3.setLongitude(3.083563);
        hospital3.setFreeBeds(5);
        hospital3.setContextMessage(null);

        hospital4.setId(4);
        hospital4.setName("Hopital Salengro");
        hospital4.setLatitude(50.610062);
        hospital4.setLongitude(3.037687);
        hospital4.setFreeBeds(0);
        hospital4.setContextMessage(null);

        hospital5.setId(5);
        hospital5.setName("Clinique Ramsay Lille Sud");
        hospital5.setLatitude(50.589062);
        hospital5.setLongitude(3.089938);
        hospital5.setFreeBeds(0);
        hospital5.setContextMessage(null);

        hospital6.setId(6);
        hospital6.setName("Clinique Ramsay Max Dormoy");
        hospital6.setLatitude(50.634687);
        hospital6.setLongitude(3.034187);
        hospital6.setFreeBeds(0);
        hospital6.setContextMessage(null);

        hospitals.add(hospital1);
        hospitals.add(hospital2);
        hospitals.add(hospital3);
        hospitals.add(hospital4);
        hospitals.add(hospital5);
        hospitals.add(hospital6);
        hospitalRepository.saveAll(hospitals);

        specialty1.setId(1);
        specialty1.setName("Cardiologie");

        specialty2.setId(2);
        specialty2.setName("Immunologie");

        specialty3.setId(3);
        specialty3.setName("Neuropathologie diagnostique");

        specialty4.setId(4);
        specialty4.setName("Nephrologie");

        specialty5.setId(5);
        specialty5.setName("Urologie");

        specialties.add(specialty1);
        specialties.add(specialty2);
        specialties.add(specialty3);
        specialties.add(specialty4);
        specialties.add(specialty5);
        specialtyRepository.saveAll(specialties);


        hsid1.setHospitalId(1);
        hsid1.setSpecialtyId(1);
        hospitalSpecialty1.setId(hsid1);
        hospitalSpecialty1.setHospital(hospital1);
        hospitalSpecialty1.setSpecialty(specialty1);

        hsid2.setHospitalId(1);
        hsid2.setSpecialtyId(2);
        hospitalSpecialty2.setId(hsid2);
        hospitalSpecialty2.setHospital(hospital1);
        hospitalSpecialty2.setSpecialty(specialty2);

        hsid3.setHospitalId(2);
        hsid3.setSpecialtyId(1);
        hospitalSpecialty3.setId(hsid3);
        hospitalSpecialty3.setHospital(hospital2);
        hospitalSpecialty3.setSpecialty(specialty1);

        hsid4.setHospitalId(2);
        hsid4.setSpecialtyId(2);
        hospitalSpecialty4.setId(hsid4);
        hospitalSpecialty4.setHospital(hospital2);
        hospitalSpecialty4.setSpecialty(specialty2);

        hsid5.setHospitalId(2);
        hsid5.setSpecialtyId(2);
        hospitalSpecialty5.setId(hsid5);
        hospitalSpecialty5.setHospital(hospital2);
        hospitalSpecialty5.setSpecialty(specialty3);

        hsid6.setHospitalId(2);
        hsid6.setSpecialtyId(4);
        hospitalSpecialty6.setId(hsid6);
        hospitalSpecialty6.setHospital(hospital2);
        hospitalSpecialty6.setSpecialty(specialty4);

        hsid7.setHospitalId(3);
        hsid7.setSpecialtyId(2);
        hospitalSpecialty7.setId(hsid7);
        hospitalSpecialty7.setHospital(hospital3);
        hospitalSpecialty7.setSpecialty(specialty2);

        hsid8.setHospitalId(3);
        hsid8.setSpecialtyId(3);
        hospitalSpecialty8.setId(hsid8);
        hospitalSpecialty8.setHospital(hospital3);
        hospitalSpecialty8.setSpecialty(specialty3);

        hsid9.setHospitalId(4);
        hsid9.setSpecialtyId(5);
        hospitalSpecialty9.setId(hsid9);
        hospitalSpecialty9.setHospital(hospital4);
        hospitalSpecialty9.setSpecialty(specialty5);

        hsid10.setHospitalId(5);
        hsid10.setSpecialtyId(5);
        hospitalSpecialty10.setId(hsid10);
        hospitalSpecialty10.setHospital(hospital5);
        hospitalSpecialty10.setSpecialty(specialty5);

        hsid11.setHospitalId(6);
        hsid11.setSpecialtyId(5);
        hospitalSpecialty11.setId(hsid11);
        hospitalSpecialty11.setHospital(hospital6);
        hospitalSpecialty11.setSpecialty(specialty5);

        hospitalsSpecialties.addAll(Arrays.asList(hospitalSpecialty1,
                hospitalSpecialty2,
                hospitalSpecialty3,
                hospitalSpecialty4,
                hospitalSpecialty5,
                hospitalSpecialty6,
                hospitalSpecialty7,
                hospitalSpecialty8,
                hospitalSpecialty9,
                hospitalSpecialty10,
                hospitalSpecialty11));
        hospitalSpecialtyRepository.saveAll(hospitalsSpecialties);

    }

    @AfterEach
    public void tearDown() {

        // Delete hospitals, specialties and hospitalSpecialties
        hospitalRepository.deleteAll();
        specialtyRepository.deleteAll();
        hospitalSpecialtyRepository.deleteAll();

    }

    @Test
    public void testLoad() {

        // Given
        HospitalSpecialtyId givenHsid1 = new HospitalSpecialtyId();
        HospitalSpecialty givenHospitalSpecialty1 = new HospitalSpecialty();

        Hospital givenHospital = new Hospital();
        Specialty givenSpecialty = new Specialty();

        givenHospital.setId(1);
        givenHospital.setName("Hopital Saint Vincent de Paul");
        givenHospital.setLatitude(50.620312);
        givenHospital.setLongitude(3.077438);
        givenHospital.setFreeBeds(2);
        givenHospital.setContextMessage(null);

        givenSpecialty.setId(1);
        givenSpecialty.setName("Cardiologie");

        givenHsid1.setHospitalId(1);
        givenHsid1.setSpecialtyId(1);
        givenHospitalSpecialty1.setId(givenHsid1);
        givenHospitalSpecialty1.setHospital(givenHospital);
        givenHospitalSpecialty1.setSpecialty(givenSpecialty);

        // When
        Mockito.when(this.hospitalSpecialtyRepository.findById(givenHsid1)).thenReturn(Optional.of(givenHospitalSpecialty1));

        // Then
        HospitalSpecialtyId newHsId = hospitalSpecialty1.getId();
        Hospital newHospital = hospitalSpecialty1.getHospital();
        Specialty newSpecialty = hospitalSpecialty1.getSpecialty();

        Assertions.assertEquals(newHsId.getHospitalId(), givenHsid1.getHospitalId());
        Assertions.assertEquals(newHospital.getName(), givenHospitalSpecialty1.getHospital().getName());
        Assertions.assertEquals(newSpecialty.getName(), givenHospitalSpecialty1.getSpecialty().getName());
    }
}
