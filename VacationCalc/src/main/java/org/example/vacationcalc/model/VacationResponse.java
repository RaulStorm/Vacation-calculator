package org.example.vacationcalc.model;

import lombok.Getter;

@Getter
public class VacationResponse {
    private double amount;

    public VacationResponse(double amount) {
        this.amount = amount;
    }

}
