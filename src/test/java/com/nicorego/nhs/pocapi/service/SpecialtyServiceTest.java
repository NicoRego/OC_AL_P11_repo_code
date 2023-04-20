package com.nicorego.nhs.pocapi.service;

import com.nicorego.nhs.pocapi.model.Specialty;
import com.nicorego.nhs.pocapi.repository.SpecialtyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SpecialtyServiceTest {

    @MockBean
    private final SpecialtyRepository specialtyRepository;
    private final SpecialtyService specialtyService;

    @Autowired
    public SpecialtyServiceTest(SpecialtyRepository specialtyRepository,
                                SpecialtyService specialtyService) {
        this.specialtyRepository = specialtyRepository;
        this.specialtyService = specialtyService;
    }

    @Test
    void getSpecialties() {

        // Given
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

        List<Specialty> expectedMockSpecialties = new ArrayList<>();
        expectedMockSpecialties.add(specialty1);
        expectedMockSpecialties.add(specialty2);
        expectedMockSpecialties.add(specialty3);
        expectedMockSpecialties.add(specialty4);
        expectedMockSpecialties.add(specialty5);

        Mockito.when(specialtyRepository.findAll()).thenReturn(expectedMockSpecialties);

        // When
        Iterable<Specialty> specialtyIterable = specialtyService.getSpecialties();

        // Then
        List<Specialty> specialtyList = new ArrayList<>();
        specialtyIterable.forEach(specialtyList::add);

        Assertions.assertEquals(expectedMockSpecialties.size(), specialtyList.size());
        Assertions.assertEquals(expectedMockSpecialties.get(0).getName(), specialtyList.get(0).getName());
        Assertions.assertEquals(expectedMockSpecialties.get(1).getName(), specialtyList.get(1).getName());
        Assertions.assertEquals(expectedMockSpecialties.get(2).getName(), specialtyList.get(2).getName());

    }

    @Test
    void getSpecialtyById() {

        // Given
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

        Mockito.when(specialtyRepository.findById(2)).thenReturn(Optional.of(specialty2));

        // When
        Optional<Specialty> searchSpecialty = specialtyService.getSpecialtyById(2);

        // Then
        if (searchSpecialty.isPresent()) {
            Assertions.assertEquals(specialty2.getId(), searchSpecialty.get().getId());
            Assertions.assertEquals(specialty2.getName(), searchSpecialty.get().getName());
        } else {
            Assertions.fail("Unable to find specialty 2 using specialtyService.getSpecialtyById(2)");
        }
    }
}