package org.example.vacationcalc.controller;

import org.example.vacationcalc.model.VacationResponse;
import org.example.vacationcalc.service.VacationCalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calculate")
public class VacationController {

    private final VacationCalculatorService calculatorService;

    public VacationController(VacationCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public VacationResponse calculate(@RequestParam double averageSalary,
                                      @RequestParam int vacationDays,
                                      @RequestParam(required = false) List<String> vacationDates) {
        List<LocalDate> dates = null;

        if (vacationDates != null && !vacationDates.isEmpty()) {
            try {
                dates = vacationDates.stream()
                        .map(date -> LocalDate.parse(date))
                        .collect(Collectors.toList());
            } catch (Exception e) {
                throw new IllegalArgumentException("Некорректный формат даты, ожидается yyyy-MM-dd.");
            }
        }

        double result = calculatorService.calculateVacation(averageSalary, vacationDays, dates);
        return new VacationResponse(result);
    }
}
