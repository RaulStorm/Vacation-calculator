package org.example.vacationcalc;

import org.example.vacationcalc.service.VacationCalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class VacationCalculatorServiceTest {

    @Autowired
    private VacationCalculatorService service;

    @Test
    void testCalculateSimple() {
        double result = service.calculateVacation(60000, 14, null);
        Assertions.assertEquals(28669.63, result);
    }

    @Test
    void testCalculateWithDates() {
        List<LocalDate> dates = List.of(
                LocalDate.of(2025, 1, 1),
                LocalDate.of(2025, 1, 2),
                LocalDate.of(2025, 1, 3),
                LocalDate.of(2025, 1, 4),
                LocalDate.of(2025, 1, 5),
                LocalDate.of(2025, 1, 6),
                LocalDate.of(2025, 1, 7)
        );
        double result = service.calculateVacation(60000, 7, dates);
        Assertions.assertEquals(1023.9, result);
    }
}
