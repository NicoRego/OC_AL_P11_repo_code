package com.nicorego.nhs.pocapi.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DistanceTest {

    Distance distanceUtils = new Distance();
    @Test
    void testDistanceHaversineEquals() {

        double expectedDist = 1.3244453977789181;
        double calculatedDist = distanceUtils.distanceHaversine(50.616312, 3.051438, 50.610937, 3.034687);

        assertEquals(expectedDist, calculatedDist,0.0);

    }

    @Test
    void testDistanceHaversineNotEquald() {

        double expectedDist = 1.0;
        double calculatedDist = distanceUtils.distanceHaversine(50.616312, 3.051438, 50.610937, 3.034687);

        assertNotEquals(expectedDist, calculatedDist);
    }
}