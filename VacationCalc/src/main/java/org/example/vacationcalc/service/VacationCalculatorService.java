package org.example.vacationcalc.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class VacationCalculatorService {

    private static final Set<LocalDate> HOLIDAYS = Set.of(
            LocalDate.of(2025, 1, 1),
            LocalDate.of(2025, 1, 7),
            LocalDate.of(2025, 2, 23),
            LocalDate.of(2025, 3, 8),
            LocalDate.of(2025, 5, 1),
            LocalDate.of(2025, 5, 9),
            LocalDate.of(2025, 6, 12),
            LocalDate.of(2025, 11, 4)
    );

    public double calculateVacation(double averageSalary, int vacationDays, List<LocalDate> vacationDates) {
        double averageDaily = averageSalary / 29.3;
        long validDays = vacationDays;

        if (vacationDates != null && !vacationDates.isEmpty()) {
            validDays = vacationDates.stream()
                    .filter(date -> !isWeekend(date) && !HOLIDAYS.contains(date))
                    .count();
        }

        return Math.round(validDays * averageDaily * 100.0) / 100.0;
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
