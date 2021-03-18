package com.national.independence.country.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.*;

    
public class CompareDatesTest {

    @Autowired
    CompareDates diferenciaEntreFechas;

    @Test
    void calculateYearsOfIndependency() {
        diferenciaEntreFechas = new CompareDates();
        String fechaIndependencia = "27/02/1884";

        Period resultado = diferenciaEntreFechas.calculateYearsOfIndependency(fechaIndependencia);

        Assertions.assertEquals(0,resultado.getMonths() );
        Assertions.assertEquals(19,resultado.getDays() );
        Assertions.assertEquals(137,resultado.getYears() );

        //https://es.calcuworld.com/calendarios/calculadora-de-tiempo-entre-dos-fechas/ you can use 
    }
}
    