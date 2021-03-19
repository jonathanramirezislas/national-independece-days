package com.national.independence.country.controller;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import com.national.independence.country.entities.Country;
import com.national.independence.country.models.CountryResponse;
import com.national.independence.country.repositories.CountryRepository;
import com.national.independence.country.util.CompareDates;

class IndependencyControllerTest {

    @Autowired
    CountryResponse countryResponse;
    @Autowired
    Optional<Country> country;

    CountryRepository countryRepositoryMock = Mockito.mock(CountryRepository.class);

    @Autowired
    CompareDates diferenciaEntreFechas = new CompareDates();

    @Autowired
    IndependencyController independencyController = new IndependencyController(countryRepositoryMock,diferenciaEntreFechas);

    @BeforeEach
    void setUp() {
        Country mockCountry = new Country();
        mockCountry.setIsoCode("DO");
        mockCountry.setCountryIdependenceDate("27/02/1844");
        mockCountry.setCountryId((long) 1);
        mockCountry.setCountryName("Republica Dominicana");
        mockCountry.setCountryCapital("Santo Domingo");

        Mockito.when(countryRepositoryMock.findCountryByIsoCode("DO")).thenReturn(mockCountry);

    }

    @Test
    void getCountryDetailsWithValidCountryCode() {
        ResponseEntity<CountryResponse> respuestaServicio;
        respuestaServicio = independencyController.getCountryDetails("DO"); //simulate the request to the endpoint getCountryDetails from controller 
        Assertions.assertEquals("Republica Dominicana",respuestaServicio.getBody().getCountryName());
    }

    @Test
    void getCountryDetailsWithInvalidCountryCode() {
        ResponseEntity<CountryResponse> respuestaServicio;
        respuestaServicio = independencyController.getCountryDetails("IT");
        Assertions.assertNull(respuestaServicio.getBody().getCountryName());
    }


}