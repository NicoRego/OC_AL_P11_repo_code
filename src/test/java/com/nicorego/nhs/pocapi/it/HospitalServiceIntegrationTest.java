package com.nicorego.nhs.pocapi.it;

import com.nicorego.nhs.pocapi.model.Hospital;
import com.nicorego.nhs.pocapi.model.HospitalSpecialty;
import com.nicorego.nhs.pocapi.model.HospitalSpecialtyId;
import com.nicorego.nhs.pocapi.model.Specialty;
import com.nicorego.nhs.pocapi.repository.HospitalRepository;
import com.nicorego.nhs.pocapi.repository.HospitalSpecialtyRepository;
import com.nicorego.nhs.pocapi.repository.SpecialtyRepository;
import com.nicorego.nhs.pocapi.service.HospitalService;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@NoArgsConstructor
public class HospitalServiceIntegrationTest {

    @Autowired
    @MockBean
    private HospitalService hospitalService;
    @Autowired
    @MockBean
    private HospitalRepository hospitalRepository;
    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Autowired
    private HospitalSpecialtyRepository hospitalSpecialtyRepository;

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

    @BeforeEach
    public void setUp() {

        // Set hospitals
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

        hospitals.add(hospital1);
        hospitals.add(hospital2);
        hospitals.add(hospital3);
        hospitalRepository.saveAll(hospitals);

        // Set specialties
        specialty1.setId(1);
        specialty1.setName("Cardiologie");
        specialty2.setId(2);
        specialty2.setName("Immunologie");
        specialty3.setId(3);
        specialty3.setName("Neuropathologie diagnostique");
        specialty4.setId(4);
        specialty4.setName("Nephrologie");
        specialty4.setId(5);
        specialty4.setName("Urologie");
        specialty4.setId(6);
        specialty4.setName("Oncologie");
        specialties.add(specialty1);
        specialties.add(specialty2);
        specialties.add(specialty3);
        specialties.add(specialty4);
        specialtyRepository.saveAll(specialties);

        // Set hospitals specialties
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
    public void testGetNearestAvailableHospital() {

        // Given
        Double searchLatitude = 50.616312;
        Double searchLongitude = 3.051438;
        Integer searchSpecialtyId = 3;

        given(hospitalService.getNearestAvailableHospital(searchLatitude, searchLongitude, searchSpecialtyId))
                .willReturn(hospital3);

        // When
        Hospital nearestHospital = hospitalService.getNearestAvailableHospital(searchLatitude, searchLongitude, searchSpecialtyId);

        // Then
        if (nearestHospital == null) {
            fail("No nearest hospital found for given conditions");
        } else {
            assertEquals(hospital3.getId(), nearestHospital.getId());
            assertEquals(hospital3.getName(), nearestHospital.getName());
        }
    }

}
