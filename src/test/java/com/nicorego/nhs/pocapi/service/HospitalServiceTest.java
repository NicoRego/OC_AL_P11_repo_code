package com.nicorego.nhs.pocapi.service;

import com.nicorego.nhs.pocapi.model.Hospital;
import com.nicorego.nhs.pocapi.model.HospitalSpecialty;
import com.nicorego.nhs.pocapi.model.HospitalSpecialtyId;
import com.nicorego.nhs.pocapi.model.Specialty;
import com.nicorego.nhs.pocapi.repository.HospitalRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HospitalServiceTest {

    @MockBean
    private final HospitalRepository hospitalRepository;
    private final HospitalService hospitalService;

    @Autowired
    public HospitalServiceTest(HospitalRepository hospitalRepository,
                               HospitalService hospitalService) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalService = hospitalService;
    }

    @Test
    void getHospitals() {

        // Given
        Hospital hospital1 = new Hospital();
        hospital1.setId(1);
        hospital1.setName("Hopital Saint Vincent de Paul");
        hospital1.setLatitude(50.620312);
        hospital1.setLongitude(3.077438);
        hospital1.setFreeBeds(2);
        hospital1.setContextMessage(null);

        Hospital hospital2 = new Hospital();
        hospital2.setId(2);
        hospital2.setName("Centre Hospitalier Universitaire de Lille");
        hospital2.setLatitude(50.610937);
        hospital2.setLongitude(3.034687);
        hospital2.setFreeBeds(0);
        hospital2.setContextMessage(null);

        Hospital hospital3 = new Hospital();
        hospital3.setId(3);
        hospital3.setName("Hopital prive La Louviere");
        hospital3.setLatitude(50.646438);
        hospital3.setLongitude(3.083563);
        hospital3.setFreeBeds(5);
        hospital3.setContextMessage(null);

        List<Hospital> expectedMockHospitals = new ArrayList<>();
        expectedMockHospitals.add(hospital1);
        expectedMockHospitals.add(hospital2);
        expectedMockHospitals.add(hospital3);

        Mockito.when(hospitalRepository.findAll()).thenReturn(expectedMockHospitals);

        // When
        Iterable<Hospital> hospitalIterable = hospitalService.getHospitals();

        // Then
        List<Hospital> hospitalList = new ArrayList<>();
        hospitalIterable.forEach(hospitalList::add);

        Assertions.assertEquals(expectedMockHospitals.size(), hospitalList.size());
        Assertions.assertEquals(expectedMockHospitals.get(0).getName(), hospitalList.get(0).getName());
        Assertions.assertEquals(expectedMockHospitals.get(1).getName(), hospitalList.get(1).getName());
        Assertions.assertEquals(expectedMockHospitals.get(2).getName(), hospitalList.get(2).getName());

    }

    @Test
    void getHospitalById() {

        // Given
        Hospital givenHospital = new Hospital();
        givenHospital.setId(2);
        givenHospital.setName("Centre Hospitalier Universitaire de Lille");
        givenHospital.setLatitude(50.610937);
        givenHospital.setLongitude(3.034687);
        givenHospital.setFreeBeds(0);

        Mockito.when(hospitalRepository.findById(2)).thenReturn(Optional.of(givenHospital));

        // When
        Optional<Hospital> searchHospital = hospitalService.getHospitalById(2);

        // Then
        if (searchHospital.isPresent()) {
            Assertions.assertEquals(givenHospital.getName(), searchHospital.get().getName());
            Assertions.assertEquals(givenHospital.getLongitude(), searchHospital.get().getLongitude());
            Assertions.assertEquals(givenHospital.getFreeBeds(), searchHospital.get().getFreeBeds());
        } else {
            Assertions.fail("Unable to find hospital 2 using hospitalService.getHospitalById(2)");
        }

    }

    @Test
    void getHospitalsBySpecialtyAndFreeBeds() {

        // Given
        Hospital hospital1 = new Hospital();
        hospital1.setId(1);
        hospital1.setName("Hopital Saint Vincent de Paul");
        hospital1.setLatitude(50.620312);
        hospital1.setLongitude(3.077438);
        hospital1.setFreeBeds(2);
        hospital1.setContextMessage(null);

        Hospital hospital2 = new Hospital();
        hospital2.setId(2);
        hospital2.setName("Centre Hospitalier Universitaire de Lille");
        hospital2.setLatitude(50.610937);
        hospital2.setLongitude(3.034687);
        hospital2.setFreeBeds(0);
        hospital2.setContextMessage(null);

        Hospital hospital3 = new Hospital();
        hospital3.setId(3);
        hospital3.setName("Hopital prive La Louviere");
        hospital3.setLatitude(50.646438);
        hospital3.setLongitude(3.083563);
        hospital3.setFreeBeds(5);
        hospital3.setContextMessage(null);

        Hospital hospital4 = new Hospital();
        hospital4.setId(4);
        hospital4.setName("Hopital Salengro");
        hospital4.setLatitude(50.610062);
        hospital4.setLongitude(3.037687);
        hospital4.setFreeBeds(0);
        hospital4.setContextMessage(null);

        Hospital hospital5 = new Hospital();
        hospital5.setId(5);
        hospital5.setName("Clinique Ramsay Lille Sud");
        hospital5.setLatitude(50.589062);
        hospital5.setLongitude(3.089938);
        hospital5.setFreeBeds(0);
        hospital5.setContextMessage(null);

        Hospital hospital6 = new Hospital();
        hospital6.setId(6);
        hospital6.setName("Clinique Ramsay Max Dormoy");
        hospital6.setLatitude(50.634687);
        hospital6.setLongitude(3.034187);
        hospital6.setFreeBeds(0);
        hospital6.setContextMessage(null);

        Specialty specialty1 = new Specialty();
        specialty1.setId(1);
        specialty1.setName("Cardiologie");

        Specialty specialty2 = new Specialty();
        specialty2.setId(2);
        specialty2.setName("Immunologie");

        Specialty specialty3 = new Specialty();
        specialty3.setId(3);
        specialty3.setName("Neuropathologie diagnostique");

        Specialty specialty4 = new Specialty();
        specialty4.setId(4);
        specialty4.setName("Nephrologie");

        Specialty specialty5 = new Specialty();
        specialty5.setId(5);
        specialty5.setName("Urologie");

        HospitalSpecialtyId hsid1 = new HospitalSpecialtyId();
        hsid1.setHospitalId(1);
        hsid1.setSpecialtyId(1);
        HospitalSpecialty hospitalSpecialty1 = new HospitalSpecialty();
        hospitalSpecialty1.setId(hsid1);
        hospitalSpecialty1.setHospital(hospital1);
        hospitalSpecialty1.setSpecialty(specialty1);

        HospitalSpecialtyId hsid2 = new HospitalSpecialtyId();
        hsid2.setHospitalId(1);
        hsid2.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty2 = new HospitalSpecialty();
        hospitalSpecialty2.setId(hsid2);
        hospitalSpecialty2.setHospital(hospital1);
        hospitalSpecialty2.setSpecialty(specialty2);

        HospitalSpecialtyId hsid3 = new HospitalSpecialtyId();
        hsid3.setHospitalId(2);
        hsid3.setSpecialtyId(1);
        HospitalSpecialty hospitalSpecialty3 = new HospitalSpecialty();
        hospitalSpecialty3.setId(hsid3);
        hospitalSpecialty3.setHospital(hospital2);
        hospitalSpecialty3.setSpecialty(specialty1);

        HospitalSpecialtyId hsid4 = new HospitalSpecialtyId();
        hsid4.setHospitalId(2);
        hsid4.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty4 = new HospitalSpecialty();
        hospitalSpecialty4.setId(hsid4);
        hospitalSpecialty4.setHospital(hospital2);
        hospitalSpecialty4.setSpecialty(specialty2);

        HospitalSpecialtyId hsid5 = new HospitalSpecialtyId();
        hsid5.setHospitalId(2);
        hsid5.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty5 = new HospitalSpecialty();
        hospitalSpecialty5.setId(hsid5);
        hospitalSpecialty5.setHospital(hospital2);
        hospitalSpecialty5.setSpecialty(specialty3);

        HospitalSpecialtyId hsid6 = new HospitalSpecialtyId();
        hsid6.setHospitalId(2);
        hsid6.setSpecialtyId(4);
        HospitalSpecialty hospitalSpecialty6 = new HospitalSpecialty();
        hospitalSpecialty6.setId(hsid6);
        hospitalSpecialty6.setHospital(hospital2);
        hospitalSpecialty6.setSpecialty(specialty4);

        HospitalSpecialtyId hsid7 = new HospitalSpecialtyId();
        hsid7.setHospitalId(3);
        hsid7.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty7 = new HospitalSpecialty();
        hospitalSpecialty7.setId(hsid7);
        hospitalSpecialty7.setHospital(hospital3);
        hospitalSpecialty7.setSpecialty(specialty2);

        HospitalSpecialtyId hsid8 = new HospitalSpecialtyId();
        hsid8.setHospitalId(3);
        hsid8.setSpecialtyId(3);
        HospitalSpecialty hospitalSpecialty8 = new HospitalSpecialty();
        hospitalSpecialty8.setId(hsid8);
        hospitalSpecialty8.setHospital(hospital3);
        hospitalSpecialty8.setSpecialty(specialty3);

        HospitalSpecialtyId hsid9 = new HospitalSpecialtyId();
        hsid9.setHospitalId(4);
        hsid9.setSpecialtyId(5);
        HospitalSpecialty hospitalSpecialty9 = new HospitalSpecialty();
        hospitalSpecialty9.setId(hsid9);
        hospitalSpecialty9.setHospital(hospital4);
        hospitalSpecialty9.setSpecialty(specialty5);

        HospitalSpecialtyId hsid10 = new HospitalSpecialtyId();
        hsid10.setHospitalId(5);
        hsid10.setSpecialtyId(5);
        HospitalSpecialty hospitalSpecialty10 = new HospitalSpecialty();
        hospitalSpecialty10.setId(hsid10);
        hospitalSpecialty10.setHospital(hospital5);
        hospitalSpecialty10.setSpecialty(specialty5);

        HospitalSpecialtyId hsid11 = new HospitalSpecialtyId();
        hsid11.setHospitalId(6);
        hsid11.setSpecialtyId(5);
        HospitalSpecialty hospitalSpecialty11 = new HospitalSpecialty();
        hospitalSpecialty11.setId(hsid11);
        hospitalSpecialty11.setHospital(hospital6);
        hospitalSpecialty11.setSpecialty(specialty5);

        List<Hospital> expectedMockHospitals = new ArrayList<>();
        expectedMockHospitals.add(hospital1);
        expectedMockHospitals.add(hospital3);

        Mockito.when(hospitalRepository.findBySpecialtyAndFreeBeds(2,0)).thenReturn(expectedMockHospitals);

        // When
        Iterable<Hospital> hospitalIterable = hospitalService.getHospitalsBySpecialtyAndFreeBeds(2,0);

        // Then
        List<Hospital> hospitalList = new ArrayList<>();
        hospitalIterable.forEach(hospitalList::add);

        // Then
        Assertions.assertEquals(hospitalList.size(), 2);
        Assertions.assertEquals(hospitalList.get(0).getName(), hospital1.getName());
        Assertions.assertEquals(hospitalList.get(1).getName(), hospital3.getName());

    }

    @Test
    void getHospitalsBySpecialty() {

        // Given
        Hospital hospital1 = new Hospital();
        hospital1.setId(1);
        hospital1.setName("Hopital Saint Vincent de Paul");
        hospital1.setLatitude(50.620312);
        hospital1.setLongitude(3.077438);
        hospital1.setFreeBeds(2);
        hospital1.setContextMessage(null);

        Hospital hospital2 = new Hospital();
        hospital2.setId(2);
        hospital2.setName("Centre Hospitalier Universitaire de Lille");
        hospital2.setLatitude(50.610937);
        hospital2.setLongitude(3.034687);
        hospital2.setFreeBeds(0);
        hospital2.setContextMessage(null);

        Hospital hospital3 = new Hospital();
        hospital3.setId(3);
        hospital3.setName("Hopital prive La Louviere");
        hospital3.setLatitude(50.646438);
        hospital3.setLongitude(3.083563);
        hospital3.setFreeBeds(5);
        hospital3.setContextMessage(null);

        Hospital hospital4 = new Hospital();
        hospital4.setId(4);
        hospital4.setName("Hopital Salengro");
        hospital4.setLatitude(50.610062);
        hospital4.setLongitude(3.037687);
        hospital4.setFreeBeds(0);
        hospital4.setContextMessage(null);

        Hospital hospital5 = new Hospital();
        hospital5.setId(5);
        hospital5.setName("Clinique Ramsay Lille Sud");
        hospital5.setLatitude(50.589062);
        hospital5.setLongitude(3.089938);
        hospital5.setFreeBeds(0);
        hospital5.setContextMessage(null);

        Hospital hospital6 = new Hospital();
        hospital6.setId(6);
        hospital6.setName("Clinique Ramsay Max Dormoy");
        hospital6.setLatitude(50.634687);
        hospital6.setLongitude(3.034187);
        hospital6.setFreeBeds(0);
        hospital6.setContextMessage(null);

        Specialty specialty1 = new Specialty();
        specialty1.setId(1);
        specialty1.setName("Cardiologie");

        Specialty specialty2 = new Specialty();
        specialty2.setId(2);
        specialty2.setName("Immunologie");

        Specialty specialty3 = new Specialty();
        specialty3.setId(3);
        specialty3.setName("Neuropathologie diagnostique");

        Specialty specialty4 = new Specialty();
        specialty4.setId(4);
        specialty4.setName("Nephrologie");

        Specialty specialty5 = new Specialty();
        specialty5.setId(5);
        specialty5.setName("Urologie");

        HospitalSpecialtyId hsid1 = new HospitalSpecialtyId();
        hsid1.setHospitalId(1);
        hsid1.setSpecialtyId(1);
        HospitalSpecialty hospitalSpecialty1 = new HospitalSpecialty();
        hospitalSpecialty1.setId(hsid1);
        hospitalSpecialty1.setHospital(hospital1);
        hospitalSpecialty1.setSpecialty(specialty1);

        HospitalSpecialtyId hsid2 = new HospitalSpecialtyId();
        hsid2.setHospitalId(1);
        hsid2.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty2 = new HospitalSpecialty();
        hospitalSpecialty2.setId(hsid2);
        hospitalSpecialty2.setHospital(hospital1);
        hospitalSpecialty2.setSpecialty(specialty2);

        HospitalSpecialtyId hsid3 = new HospitalSpecialtyId();
        hsid3.setHospitalId(2);
        hsid3.setSpecialtyId(1);
        HospitalSpecialty hospitalSpecialty3 = new HospitalSpecialty();
        hospitalSpecialty3.setId(hsid3);
        hospitalSpecialty3.setHospital(hospital2);
        hospitalSpecialty3.setSpecialty(specialty1);

        HospitalSpecialtyId hsid4 = new HospitalSpecialtyId();
        hsid4.setHospitalId(2);
        hsid4.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty4 = new HospitalSpecialty();
        hospitalSpecialty4.setId(hsid4);
        hospitalSpecialty4.setHospital(hospital2);
        hospitalSpecialty4.setSpecialty(specialty2);

        HospitalSpecialtyId hsid5 = new HospitalSpecialtyId();
        hsid5.setHospitalId(2);
        hsid5.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty5 = new HospitalSpecialty();
        hospitalSpecialty5.setId(hsid5);
        hospitalSpecialty5.setHospital(hospital2);
        hospitalSpecialty5.setSpecialty(specialty3);

        HospitalSpecialtyId hsid6 = new HospitalSpecialtyId();
        hsid6.setHospitalId(2);
        hsid6.setSpecialtyId(4);
        HospitalSpecialty hospitalSpecialty6 = new HospitalSpecialty();
        hospitalSpecialty6.setId(hsid6);
        hospitalSpecialty6.setHospital(hospital2);
        hospitalSpecialty6.setSpecialty(specialty4);

        HospitalSpecialtyId hsid7 = new HospitalSpecialtyId();
        hsid7.setHospitalId(3);
        hsid7.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty7 = new HospitalSpecialty();
        hospitalSpecialty7.setId(hsid7);
        hospitalSpecialty7.setHospital(hospital3);
        hospitalSpecialty7.setSpecialty(specialty2);

        HospitalSpecialtyId hsid8 = new HospitalSpecialtyId();
        hsid8.setHospitalId(3);
        hsid8.setSpecialtyId(3);
        HospitalSpecialty hospitalSpecialty8 = new HospitalSpecialty();
        hospitalSpecialty8.setId(hsid8);
        hospitalSpecialty8.setHospital(hospital3);
        hospitalSpecialty8.setSpecialty(specialty3);

        HospitalSpecialtyId hsid9 = new HospitalSpecialtyId();
        hsid9.setHospitalId(4);
        hsid9.setSpecialtyId(5);
        HospitalSpecialty hospitalSpecialty9 = new HospitalSpecialty();
        hospitalSpecialty9.setId(hsid9);
        hospitalSpecialty9.setHospital(hospital4);
        hospitalSpecialty9.setSpecialty(specialty5);

        HospitalSpecialtyId hsid10 = new HospitalSpecialtyId();
        hsid10.setHospitalId(5);
        hsid10.setSpecialtyId(5);
        HospitalSpecialty hospitalSpecialty10 = new HospitalSpecialty();
        hospitalSpecialty10.setId(hsid10);
        hospitalSpecialty10.setHospital(hospital5);
        hospitalSpecialty10.setSpecialty(specialty5);

        HospitalSpecialtyId hsid11 = new HospitalSpecialtyId();
        hsid11.setHospitalId(6);
        hsid11.setSpecialtyId(5);
        HospitalSpecialty hospitalSpecialty11 = new HospitalSpecialty();
        hospitalSpecialty11.setId(hsid11);
        hospitalSpecialty11.setHospital(hospital6);
        hospitalSpecialty11.setSpecialty(specialty5);

        List<Hospital> expectedMockHospitals = new ArrayList<>();
        expectedMockHospitals.add(hospital2);
        expectedMockHospitals.add(hospital3);

        Mockito.when(hospitalRepository.findBySpecialty(3)).thenReturn(expectedMockHospitals);

        // When
        Iterable<Hospital> hospitalIterable = hospitalService.getHospitalsBySpecialty(3);

        // Then
        List<Hospital> hospitalList = new ArrayList<>();
        hospitalIterable.forEach(hospitalList::add);

        // Then
        Assertions.assertEquals(hospitalList.size(), 2);
        Assertions.assertEquals(hospitalList.get(0).getName(), hospital2.getName());
        Assertions.assertEquals(hospitalList.get(1).getName(), hospital3.getName());

    }

    @Test
    void bedBooking() {

        // Given
        Hospital hospital3 = new Hospital();
        hospital3.setId(3);
        hospital3.setName("Hopital prive La Louviere");
        hospital3.setLatitude(50.646438);
        hospital3.setLongitude(3.083563);
        hospital3.setFreeBeds(5);
        hospital3.setContextMessage(null);

        Mockito.when(hospitalRepository.findById(3)).thenReturn(Optional.of(hospital3));

        // When
        Hospital bookedHospital = hospitalService.bedBooking(hospital3);
        int bookedHospitalFreeBeds = bookedHospital.getFreeBeds();

        // Then
        Assertions.assertEquals(4, bookedHospitalFreeBeds);

    }

    @Test
    void bedBooking_NoUpdate() {

        // Given
        Hospital hospital3 = new Hospital();
        hospital3.setId(3);
        hospital3.setName("Hopital prive La Louviere");
        hospital3.setLatitude(50.646438);
        hospital3.setLongitude(3.083563);
        hospital3.setFreeBeds(0);
        hospital3.setContextMessage(null);

        Mockito.when(hospitalRepository.findById(3)).thenReturn(Optional.of(hospital3));

        // When
        Hospital bookedHospital = hospitalService.bedBooking(hospital3);
        int bookedHospitalFreeBeds = bookedHospital.getFreeBeds();

        // Then
        Assertions.assertEquals(0, bookedHospitalFreeBeds);

    }

    @Test
    void cancelBedBooking() {

        // Given
        Hospital hospital1 = new Hospital();
        hospital1.setId(1);
        hospital1.setName("Hopital Saint Vincent de Paul");
        hospital1.setLatitude(50.620312);
        hospital1.setLongitude(3.077438);
        hospital1.setFreeBeds(2);
        hospital1.setContextMessage(null);

        Mockito.when(hospitalRepository.findById(1)).thenReturn(Optional.of(hospital1));

        // When
        Hospital cancelBookedHospital = hospitalService.cancelBedBooking(hospital1);
        int cancelBookedHospitalFreeBeds = cancelBookedHospital.getFreeBeds();

        // Then
        Assertions.assertEquals(3, cancelBookedHospitalFreeBeds);

    }

    @Test
    void saveHospital() {

        // Given
        Hospital hospital4 = new Hospital();
        hospital4.setId(4);
        hospital4.setName("Hopital Roger Salengro");
        hospital4.setLatitude(50.607563);
        hospital4.setLongitude(3.032188);
        hospital4.setFreeBeds(10);

        // When
        when(hospitalRepository.save(hospital4)).thenReturn(hospital4);

        // Test hospital service method
        Hospital savedHospital = hospitalService.saveHospital(hospital4);

        // Then
        verify(hospitalRepository).save(hospital4);

        Assertions.assertEquals(hospital4, savedHospital);
    }

    @Test
    public void testGetNearestAvailableHospital_ErrorLatitude() {

        // Given
        Double searchLatitude = 0.0;
        Double searchLongitude = 3.051438;
        Integer searchSpecialtyId = 3;

        // When
        Mockito.when(hospitalRepository.findById(0)).thenReturn(null);

        // Then
        Hospital nearestHospital = hospitalService.getNearestAvailableHospital(searchLatitude, searchLongitude, searchSpecialtyId);

        assertNull("Return should be null", nearestHospital);

    }

    @Test
    public void testGetNearestAvailableHospital_ErrorLongitude() {

        // Given
        Double searchLatitude = 50.616312;
        Double searchLongitude = 0.0;
        Integer searchSpecialtyId = 3;

        // When
        Mockito.when(hospitalRepository.findById(0)).thenReturn(null);

        // Then
        Hospital nearestHospital = hospitalService.getNearestAvailableHospital(searchLatitude, searchLongitude, searchSpecialtyId);

        assertNull("Return should be null", nearestHospital);

    }

    @Test
    public void testGetNearestAvailableHospital_ErrorSpecialty() {

        // Given
        Double searchLatitude = 50.616312;
        Double searchLongitude = 3.051438;
        Integer searchSpecialty = 0;

        // When
        Mockito.when(hospitalRepository.findBySpecialty(searchSpecialty)).thenReturn(null);

        // Then
        Hospital nearestHospital = hospitalService.getNearestAvailableHospital(searchLatitude, searchLongitude, searchSpecialty);

        assertNull("Return should be null", nearestHospital);

    }

    @Test
    public void testGetNearestAvailableHospital_NoNearestHospital() {

        // Given
        Double searchLatitude = 50.616312;
        Double searchLongitude = 3.051438;
        Integer searchSpecialtyId = 6;

        // When
        Mockito.when(hospitalRepository.findBySpecialty(6)).thenReturn(null);

        // Then
        Hospital nearestHospital = hospitalService.getNearestAvailableHospital(searchLatitude, searchLongitude, searchSpecialtyId);

        assertNull("Return should be null", nearestHospital);

    }

    @Test
    public void testGetNearestAvailableHospital_NoFreeBeds() {

        // Given
        Hospital hospital1 = new Hospital();
        hospital1.setId(1);
        hospital1.setName("Hopital Saint Vincent de Paul");
        hospital1.setLatitude(50.620312);
        hospital1.setLongitude(3.077438);
        hospital1.setFreeBeds(2);
        hospital1.setContextMessage(null);

        Hospital hospital2 = new Hospital();
        hospital2.setId(2);
        hospital2.setName("Centre Hospitalier Universitaire de Lille");
        hospital2.setLatitude(50.610937);
        hospital2.setLongitude(3.034687);
        hospital2.setFreeBeds(0);
        hospital2.setContextMessage(null);

        Hospital hospital3 = new Hospital();
        hospital3.setId(3);
        hospital3.setName("Hopital prive La Louviere");
        hospital3.setLatitude(50.646438);
        hospital3.setLongitude(3.083563);
        hospital3.setFreeBeds(5);
        hospital3.setContextMessage(null);

        Hospital hospital4 = new Hospital();
        hospital4.setId(4);
        hospital4.setName("Hopital Salengro");
        hospital4.setLatitude(50.610062);
        hospital4.setLongitude(3.037687);
        hospital4.setFreeBeds(0);
        hospital4.setContextMessage(null);

        Hospital hospital5 = new Hospital();
        hospital5.setId(5);
        hospital5.setName("Clinique Ramsay Lille Sud");
        hospital5.setLatitude(50.589062);
        hospital5.setLongitude(3.089938);
        hospital5.setFreeBeds(0);
        hospital5.setContextMessage(null);

        Hospital hospital6 = new Hospital();
        hospital6.setId(6);
        hospital6.setName("Clinique Ramsay Max Dormoy");
        hospital6.setLatitude(50.634687);
        hospital6.setLongitude(3.034187);
        hospital6.setFreeBeds(0);
        hospital6.setContextMessage(null);

        Specialty specialty1 = new Specialty();
        specialty1.setId(1);
        specialty1.setName("Cardiologie");

        Specialty specialty2 = new Specialty();
        specialty2.setId(2);
        specialty2.setName("Immunologie");

        Specialty specialty3 = new Specialty();
        specialty3.setId(3);
        specialty3.setName("Neuropathologie diagnostique");

        Specialty specialty4 = new Specialty();
        specialty4.setId(4);
        specialty4.setName("Nephrologie");

        Specialty specialty5 = new Specialty();
        specialty5.setId(5);
        specialty5.setName("Urologie");

        HospitalSpecialtyId hsid1 = new HospitalSpecialtyId();
        hsid1.setHospitalId(1);
        hsid1.setSpecialtyId(1);
        HospitalSpecialty hospitalSpecialty1 = new HospitalSpecialty();
        hospitalSpecialty1.setId(hsid1);
        hospitalSpecialty1.setHospital(hospital1);
        hospitalSpecialty1.setSpecialty(specialty1);

        HospitalSpecialtyId hsid2 = new HospitalSpecialtyId();
        hsid2.setHospitalId(1);
        hsid2.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty2 = new HospitalSpecialty();
        hospitalSpecialty2.setId(hsid2);
        hospitalSpecialty2.setHospital(hospital1);
        hospitalSpecialty2.setSpecialty(specialty2);

        HospitalSpecialtyId hsid3 = new HospitalSpecialtyId();
        hsid3.setHospitalId(2);
        hsid3.setSpecialtyId(1);
        HospitalSpecialty hospitalSpecialty3 = new HospitalSpecialty();
        hospitalSpecialty3.setId(hsid3);
        hospitalSpecialty3.setHospital(hospital2);
        hospitalSpecialty3.setSpecialty(specialty1);

        HospitalSpecialtyId hsid4 = new HospitalSpecialtyId();
        hsid4.setHospitalId(2);
        hsid4.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty4 = new HospitalSpecialty();
        hospitalSpecialty4.setId(hsid4);
        hospitalSpecialty4.setHospital(hospital2);
        hospitalSpecialty4.setSpecialty(specialty2);

        HospitalSpecialtyId hsid5 = new HospitalSpecialtyId();
        hsid5.setHospitalId(2);
        hsid5.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty5 = new HospitalSpecialty();
        hospitalSpecialty5.setId(hsid5);
        hospitalSpecialty5.setHospital(hospital2);
        hospitalSpecialty5.setSpecialty(specialty3);

        HospitalSpecialtyId hsid6 = new HospitalSpecialtyId();
        hsid6.setHospitalId(2);
        hsid6.setSpecialtyId(4);
        HospitalSpecialty hospitalSpecialty6 = new HospitalSpecialty();
        hospitalSpecialty6.setId(hsid6);
        hospitalSpecialty6.setHospital(hospital2);
        hospitalSpecialty6.setSpecialty(specialty4);

        HospitalSpecialtyId hsid7 = new HospitalSpecialtyId();
        hsid7.setHospitalId(3);
        hsid7.setSpecialtyId(2);
        HospitalSpecialty hospitalSpecialty7 = new HospitalSpecialty();
        hospitalSpecialty7.setId(hsid7);
        hospitalSpecialty7.setHospital(hospital3);
        hospitalSpecialty7.setSpecialty(specialty2);

        HospitalSpecialtyId hsid8 = new HospitalSpecialtyId();
        hsid8.setHospitalId(3);
        hsid8.setSpecialtyId(3);
        HospitalSpecialty hospitalSpecialty8 = new HospitalSpecialty();
        hospitalSpecialty8.setId(hsid8);
        hospitalSpecialty8.setHospital(hospital3);
        hospitalSpecialty8.setSpecialty(specialty3);

        HospitalSpecialtyId hsid9 = new HospitalSpecialtyId();
        hsid9.setHospitalId(4);
        hsid9.setSpecialtyId(5);
        HospitalSpecialty hospitalSpecialty9 = new HospitalSpecialty();
        hospitalSpecialty9.setId(hsid9);
        hospitalSpecialty9.setHospital(hospital4);
        hospitalSpecialty9.setSpecialty(specialty5);

        HospitalSpecialtyId hsid10 = new HospitalSpecialtyId();
        hsid10.setHospitalId(5);
        hsid10.setSpecialtyId(5);
        HospitalSpecialty hospitalSpecialty10 = new HospitalSpecialty();
        hospitalSpecialty10.setId(hsid10);
        hospitalSpecialty10.setHospital(hospital5);
        hospitalSpecialty10.setSpecialty(specialty5);

        HospitalSpecialtyId hsid11 = new HospitalSpecialtyId();
        hsid11.setHospitalId(6);
        hsid11.setSpecialtyId(5);
        HospitalSpecialty hospitalSpecialty11 = new HospitalSpecialty();
        hospitalSpecialty11.setId(hsid11);
        hospitalSpecialty11.setHospital(hospital6);
        hospitalSpecialty11.setSpecialty(specialty5);

        Double searchLatitude = 50.616312;
        Double searchLongitude = 3.051438;
        Integer searchSpecialtyId = 5;

        // When
        Mockito.when(hospitalRepository.findBySpecialtyAndFreeBeds(5,0)).thenReturn(null);

        // Then
        Hospital nearestHospital = hospitalService.getNearestAvailableHospital(searchLatitude, searchLongitude, searchSpecialtyId);

        assertNull("Return should be null", nearestHospital);

    }
}