package com.nicorego.nhs.pocapi.it;

import com.nicorego.nhs.pocapi.model.Hospital;
import com.nicorego.nhs.pocapi.model.HospitalSpecialty;
import com.nicorego.nhs.pocapi.model.HospitalSpecialtyId;
import com.nicorego.nhs.pocapi.model.Specialty;
import com.nicorego.nhs.pocapi.repository.HospitalRepository;
import com.nicorego.nhs.pocapi.repository.HospitalSpecialtyRepository;
import com.nicorego.nhs.pocapi.repository.SpecialtyRepository;
import com.nicorego.nhs.pocapi.service.HospitalService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.nicorego.nhs.pocapi.utils.JsonMapper.getHospitalJson;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
public class HospitalControllerIntegrationTest {

    private final MockMvc mvc;

    @MockBean
    private final HospitalService hospitalService;

    @MockBean
    private final HospitalRepository hospitalRepository;
    @MockBean
    private final SpecialtyRepository specialtyRepository;
    @MockBean
    private final HospitalSpecialtyRepository hospitalSpecialtyRepository;

    @Autowired
    public HospitalControllerIntegrationTest(MockMvc mvc, HospitalService hospitalService, HospitalRepository hospitalRepository, SpecialtyRepository specialtyRepository, HospitalSpecialtyRepository hospitalSpecialtyRepository) {
        this.mvc = mvc;
        this.hospitalService = hospitalService;
        this.hospitalRepository = hospitalRepository;
        this.specialtyRepository = specialtyRepository;
        this.hospitalSpecialtyRepository = hospitalSpecialtyRepository;
    }

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
    public void setUp(){

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

        // Set specialties
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

    // *****************************************************************************
    // **                                                                         **
    // **                    getNearestAvailableHospital tests                    **
    // **                                                                         **
    // *****************************************************************************

    @Test
    public void getNearestAvailableHospital_WillReturnOKWithId1() throws Exception {

        // Set request attributes
        String searchLatitude = "50.616312";
        String searchLongitude = "3.051438";
        Integer searchSpecialtyId = 1;

        // Given
        given(hospitalService.getNearestAvailableHospital(Double.parseDouble(searchLatitude), Double.parseDouble(searchLongitude), searchSpecialtyId))
                .willReturn(hospital1);

        // Set expected json object
        String responseHospitalJsonString = getHospitalJson(hospital1).toString();

        // When
        String url = String.format("/search/nearest?latitude=%s&longitude=%s&specialty=%d", searchLatitude, searchLongitude, searchSpecialtyId);

        MockHttpServletRequestBuilder requestBuilder = get(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(responseHospitalJsonString))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(responseHospitalJsonString);

    }

    @Test
    public void getNearestAvailableHospital_WillReturnNotFound() throws Exception {

        // Set request attributes
        String searchLatitude = "50.616312";
        String searchLongitude = "3.051438";
        Integer searchSpecialtyId = 4;

        // Set response attributes
        Hospital notFoundHospital = new Hospital();
        notFoundHospital.setContextMessage(String.format("No nearest/available hospital found for specialty '%d' @ %s,%s", searchSpecialtyId, searchLatitude, searchLongitude));
        String responseHospitalJsonString = getHospitalJson(notFoundHospital).toString();

        // Given
        given(hospitalService.getNearestAvailableHospital(Double.parseDouble(searchLatitude), Double.parseDouble(searchLongitude), searchSpecialtyId))
                .willReturn(null);

        // When
        String url = String.format("/search/nearest?latitude=%s&longitude=%s&specialty=%d", searchLatitude, searchLongitude, searchSpecialtyId);

        MockHttpServletRequestBuilder requestBuilder = get(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(content().json(responseHospitalJsonString))
                .andReturn();

        // Then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(result.getResponse().getContentAsString()).isEqualTo(responseHospitalJsonString);

    }

    @Test
    public void getNearestAvailableHospital_WillReturnBadRequest() throws Exception {

        // Set request attributes
        String searchLatitude = "50.616312";
        String searchLongitude = "3.051438";

        // Set expected json object
        Hospital responseHospital = new Hospital();

        // Given
        given(hospitalService.getNearestAvailableHospital(Double.parseDouble(searchLatitude), Double.parseDouble(searchLongitude),null))
                .willReturn(responseHospital);

        // When
        String url = String.format("/search/nearest?latitude=.%s&longitude=%s&specialty=", searchLatitude, searchLongitude);

        MockHttpServletRequestBuilder requestBuilder = get(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isBadRequest())
                .andReturn();

        // Then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());

    }

    // *****************************************************************************
    // **                                                                         **
    // **                            getHospital tests                            **
    // **                                                                         **
    // *****************************************************************************

    @Test
    void getHospital_WillReturnOK() throws Exception {

        // Set expected json object
        Hospital responseHospital = hospital3;
        responseHospital.setContextMessage("Hospital 3 found successfully");
        String responseHospitalJsonString = getHospitalJson(hospital3).toString();

        // Given
        given(hospitalService.getHospitalById(3)).willReturn(Optional.of(hospital3));

        // When
        String url = "/search/hospital?id=3";

        MockHttpServletRequestBuilder requestBuilder = get(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andReturn();

        // Then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(result.getResponse().getContentAsString()).isEqualTo(responseHospitalJsonString);

    }

    @Test
    void getHospital_WillReturnNotFound() throws Exception {

        // Given
        Hospital givenHospital = new Hospital();

        // Set expected json object
        Hospital responseHospital = new Hospital();
        responseHospital.setContextMessage("Hospital 4 not found");

        String responseHospitalJsonString = getHospitalJson(responseHospital).toString();

        Mockito.when(this.hospitalRepository.findById(4)).thenReturn(Optional.of(givenHospital));

        // When
        String url = "/search/hospital?id=4";

        MockHttpServletRequestBuilder requestBuilder = get(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andReturn();

        // Then
        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(result.getResponse().getContentAsString()).isEqualTo(responseHospitalJsonString);

    }

    // *****************************************************************************
    // **                                                                         **
    // **                            bedBooking  tests                            **
    // **                                                                         **
    // *****************************************************************************

    @Test
    public void bedBooking_WillReturnOk() throws Exception {

        // Given - Is hospital3 object

        // Set expected json object
        Hospital responseHospital = new Hospital();

        responseHospital.setId(3);
        responseHospital.setName("Hopital prive La Louviere");
        responseHospital.setLatitude(50.646438);
        responseHospital.setLongitude(3.083563);
        responseHospital.setFreeBeds(4);
        responseHospital.setContextMessage("Bed booked successfully in hospital 3");

        String responseHospitalString = getHospitalJson(responseHospital).toString();

        Mockito.when(this.hospitalService.getHospitalById(3)).thenReturn(Optional.of(hospital3));
        Mockito.when(this.hospitalService.bedBooking(hospital3)).thenReturn(responseHospital);

        // When
        String url = "/bed/booking?hospital=3";

        MockHttpServletRequestBuilder requestBuilder = put(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(responseHospitalString))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(responseHospitalString);

    }

    @Test
    public void bedBooking_NoBedAvailable() throws Exception {

        // Given

        // Set expected json object
        Hospital responseHospital = new Hospital();

        responseHospital.setId(2);
        responseHospital.setName("Centre Hospitalier Universitaire de Lille");
        responseHospital.setLatitude(50.610937);
        responseHospital.setLongitude(3.034687);
        responseHospital.setFreeBeds(0);
        responseHospital.setContextMessage("No bed available in Hospital 2");

        String responseHospitalString = getHospitalJson(responseHospital).toString();

        Mockito.when(this.hospitalService.getHospitalById(2)).thenReturn(Optional.of(hospital2));
        Mockito.when(this.hospitalService.bedBooking(hospital2)).thenReturn(responseHospital);

        // When
        String url = "/bed/booking?hospital=2";

        MockHttpServletRequestBuilder requestBuilder = put(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isConflict())
                .andExpect(content().json(responseHospitalString))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
        assertThat(response.getContentAsString()).isEqualTo(responseHospitalString);

    }

    @Test
    public void bedBooking_WillReturnNotFound() throws Exception {

        // Given
        Hospital givenHospital = new Hospital();

        // Set expected json object
        Hospital responseHospital = new Hospital();

        responseHospital.setId(0);
        responseHospital.setName("");
        responseHospital.setLatitude(0.0);
        responseHospital.setLongitude(0.0);
        responseHospital.setFreeBeds(0);
        responseHospital.setContextMessage("Hospital 5 not found");

        String responseHospitalJsonString = getHospitalJson(responseHospital).toString();

        Mockito.when(this.hospitalService.getHospitalById(5)).thenReturn(Optional.empty());
        Mockito.when(this.hospitalService.bedBooking(givenHospital)).thenReturn(responseHospital);

        // When
        String url = "/bed/booking?hospital=5";

        MockHttpServletRequestBuilder requestBuilder = put(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(content().json(responseHospitalJsonString))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getContentAsString()).isEqualTo(responseHospitalJsonString);

    }

    @Test
    public void bedBooking_invalidInput() throws Exception {
        mvc.perform(put("/bed/booking"))
                .andExpect(status().isBadRequest());
    }

    // *****************************************************************************
    // **                                                                         **
    // **                         cancelBedBooking  tests                         **
    // **                                                                         **
    // *****************************************************************************

    @Test
    public void cancelBedBooking_WillReturnOk() throws Exception {

        // Given

        // Set expected json object
        Hospital responseHospital = new Hospital();

        responseHospital.setId(3);
        responseHospital.setName("Hopital prive La Louviere");
        responseHospital.setLatitude(50.646438);
        responseHospital.setLongitude(3.083563);
        responseHospital.setFreeBeds(6);
        responseHospital.setContextMessage("Booking cancelled successfully in hospital 3");

        String responseHospitalString = getHospitalJson(responseHospital).toString();

        Mockito.when(this.hospitalService.getHospitalById(3)).thenReturn(Optional.of(hospital3));
        Mockito.when(this.hospitalService.cancelBedBooking(hospital3)).thenReturn(responseHospital);

        // When
        String url = "/bed/booking/cancel?hospital=3";

        MockHttpServletRequestBuilder requestBuilder = put(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(responseHospitalString))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(responseHospitalString);

    }

    @Test
    public void cancelBedBooking_WillReturnConflict() throws Exception {

        // Given

        // Set expected json object
        Hospital responseHospital = new Hospital();

        responseHospital.setId(3);
        responseHospital.setName("Hopital prive La Louviere");
        responseHospital.setLatitude(50.646438);
        responseHospital.setLongitude(3.083563);
        responseHospital.setFreeBeds(0);
        responseHospital.setContextMessage("Unable to cancel booking in Hospital 3");

        String responseHospitalString = getHospitalJson(responseHospital).toString();

        Mockito.when(this.hospitalService.getHospitalById(3)).thenReturn(Optional.of(hospital3));
        Mockito.when(this.hospitalService.cancelBedBooking(hospital3)).thenReturn(responseHospital);

        // When
        String url = "/bed/booking/cancel?hospital=3";

        MockHttpServletRequestBuilder requestBuilder = put(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isConflict())
                .andExpect(content().json(responseHospitalString))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CONFLICT.value());
        assertThat(response.getContentAsString()).isEqualTo(responseHospitalString);

    }

    @Test
    public void cancelBedBooking_WillReturnNotFound() throws Exception {

        // Given
        Hospital givenHospital = new Hospital();

        // Set expected json object
        Hospital responseHospital = new Hospital();

        responseHospital.setId(0);
        responseHospital.setName("");
        responseHospital.setLatitude(0.0);
        responseHospital.setLongitude(0.0);
        responseHospital.setFreeBeds(0);
        responseHospital.setContextMessage("Hospital 5 not found");

        String responseHospitalJsonString = getHospitalJson(responseHospital).toString();

        Mockito.when(this.hospitalService.getHospitalById(5)).thenReturn(Optional.empty());
        Mockito.when(this.hospitalService.cancelBedBooking(givenHospital)).thenReturn(responseHospital);

        // When
        String url = "/bed/booking/cancel?hospital=5";

        MockHttpServletRequestBuilder requestBuilder = put(url);

        MvcResult result = mvc.perform(requestBuilder)
                .andExpect(status().isNotFound())
                .andExpect(content().json(responseHospitalJsonString))
                .andReturn();

        MockHttpServletResponse response = result.getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getContentAsString()).isEqualTo(responseHospitalJsonString);

    }

    @Test
    public void cancelBedBooking_invalidInput() throws Exception {
        mvc.perform(put("/bed/booking/cancel"))
                .andExpect(status().isBadRequest());
    }
}
