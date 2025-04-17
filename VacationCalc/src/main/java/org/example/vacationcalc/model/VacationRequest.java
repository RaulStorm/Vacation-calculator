package org.example.vacationcalc.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class VacationRequest {
    private double averageSalary;
    private int vacationDays;
    private List<LocalDate> vacationDates;

}
