package com.nicorego.nhs.pocapi.utils;

import com.nicorego.nhs.pocapi.model.Hospital;
import com.nicorego.nhs.pocapi.service.HospitalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.nicorego.nhs.pocapi.utils.JsonMapper.getHospitalJson;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JsonMapperTest {

    @Autowired
    HospitalService hospitalService;

    @Test
    void testGetHospitalJsonEquals() {

        Hospital expectedHospital = new Hospital();
        expectedHospital.setId(1);
        expectedHospital.setName("Hopital Saint Vincent de Paul");
        expectedHospital.setLatitude(50.620312);
        expectedHospital.setLongitude(3.077438);
        expectedHospital.setFreeBeds(2);
        expectedHospital.setContextMessage(null);

        String expectedHospitalJsonString = getHospitalJson(expectedHospital).toString();

        Optional<Hospital> selectedHospital = hospitalService.getHospitalById(1);
        String selectedHospitalJsonString = getHospitalJson(selectedHospital.get()).toString();

        assertEquals(expectedHospitalJsonString, selectedHospitalJsonString);
    }

    @Test
    void testGetHospitalJsonNotEquals() {

        Hospital expectedHospital = new Hospital();
        expectedHospital.setId(1);
        expectedHospital.setName("Hopital Saint Vincent de Paul");
        expectedHospital.setLatitude(50.620312);
        expectedHospital.setLongitude(3.077438);
        expectedHospital.setFreeBeds(2);
        expectedHospital.setContextMessage(null);
        String expectedHospitalJsonString = getHospitalJson(expectedHospital).toString();

        Optional<Hospital> selectedHospital = hospitalService.getHospitalById(2);
        String selectedHospitalJsonString = getHospitalJson(selectedHospital.get()).toString();

        assertNotEquals(expectedHospitalJsonString, selectedHospitalJsonString);
    }
    @Test
    void testGetHospitalJsonNullPointerException() {

        String expectedHospitalJsonString = "{\"error\":\"Hospital object contains null values\"}";

        Hospital selectedHospital = null;

        String selectedHospitalJsonString = getHospitalJson(selectedHospital).toString();

        assertEquals(expectedHospitalJsonString, selectedHospitalJsonString);

    }

}