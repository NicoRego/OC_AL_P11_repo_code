package com.nicorego.nhs.pocapi.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalTest {

    @Test
    void testToString() {

        String expectedHospitalToString = "Hospital(id=2, name=Centre Hospitalier Universitaire de Lille, latitude=50.610937, longitude=3.034687, freeBeds=0, contextMessage=null)";

        Hospital hospital = new Hospital();
        hospital.setId(2);
        hospital.setName("Centre Hospitalier Universitaire de Lille");
        hospital.setLatitude(50.610937);
        hospital.setLongitude(3.034687);
        hospital.setFreeBeds(0);
        hospital.setContextMessage(null);

        String hospitalToString = hospital.toString();

        assertEquals(expectedHospitalToString,hospitalToString);
    }

    @Test
    void testGetIdEquals() {

        Hospital hospital = new Hospital();
        hospital.setId(2);
        Integer id = hospital.getId();

        assertEquals(2,id);

    }

    @Test
    void testGetIdNotEquals() {

        Hospital hospital = new Hospital();
        hospital.setId(2);
        Integer id = hospital.getId();

        assertNotEquals(1,id);

    }

    @Test
    void testGetNameEquals() {

        Hospital hospital = new Hospital();
        String expectedName = "Centre Hospitalier Universitaire de Lille";
        hospital.setName(expectedName);
        String name = hospital.getName();

        assertEquals(expectedName,name);

    }
    @Test
    void testGetNameNotEquals() {

        Hospital hospital = new Hospital();
        String expectedName = "Hopital Saint Vincent de Paul";
        hospital.setName("Centre Hospitalier Universitaire de Lille");
        String name = hospital.getName();

        assertNotEquals(expectedName,name);

    }

    @Test
    void testGetLatitudeEquals() {

        Hospital hospital = new Hospital();
        Double expectedLatitude = 50.610937;
        hospital.setLatitude(50.610937);

        Double latitude = hospital.getLatitude();

        assertEquals(expectedLatitude,latitude);

    }

    @Test
    void testGetLatitudeNotEquals() {

        Hospital hospital = new Hospital();
        Double expectedLatitude = 50.620312;
        hospital.setLatitude(50.610937);

        Double latitude = hospital.getLatitude();

        assertNotEquals(expectedLatitude,latitude);
    }

    @Test
    void testGetLongitudeEquals() {

        Hospital hospital = new Hospital();
        Double expectedLongitude = 3.077438;
        hospital.setLongitude(3.077438);

        Double longitude = hospital.getLongitude();

        assertEquals(expectedLongitude, longitude);

    }

    @Test
    void testGetLongitudeNotEquals() {

        Hospital hospital = new Hospital();
        Double expectedLongitude = 3.077438;
        hospital.setLongitude(3.034687);

        Double longitude = hospital.getLatitude();

        assertNotEquals(expectedLongitude, longitude);
    }

    @Test
    void testGetFreeBedsEquals() {

        Hospital hospital = new Hospital();
        Integer expectedFreeBeds = 2;
        hospital.setFreeBeds(2);

        Integer freeBeds = hospital.getFreeBeds();

        assertEquals(expectedFreeBeds, freeBeds);
    }

    @Test
    void testGetFreeBedsNotEquals() {

        Hospital hospital = new Hospital();
        Integer expectedFreeBeds = 0;
        hospital.setFreeBeds(2);

        Integer freeBeds = hospital.getFreeBeds();

        assertNotEquals(expectedFreeBeds, freeBeds);
    }

    @Test
    void testGetContextMessageEquals() {

        Hospital hospital = new Hospital();
        String expectedContextMessage = "No bed available in Hospital 3";
        hospital.setContextMessage(expectedContextMessage);
        String contextMessage = hospital.getContextMessage();

        assertEquals(expectedContextMessage,contextMessage);
    }

    @Test
    void testGetContextMessageNotEquals() {

        Hospital hospital = new Hospital();
        String expectedContextMessage = "No bed available in Hospital 3";
        hospital.setContextMessage("Bed booked successfully in hospital 3");
        String contextMessage = hospital.getContextMessage();

        assertNotEquals(expectedContextMessage,contextMessage);
    }
}