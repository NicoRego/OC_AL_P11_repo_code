package com.nicorego.nhs.pocapi.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HospitalSpecialtyIdTest {

    @Test
    public void testGetterAndSetter() {
        HospitalSpecialtyId id = new HospitalSpecialtyId();
        id.setHospitalId(1);
        id.setSpecialtyId(2);

        Assertions.assertEquals(1, id.getHospitalId());
        Assertions.assertEquals(2, id.getSpecialtyId());
    }
}
