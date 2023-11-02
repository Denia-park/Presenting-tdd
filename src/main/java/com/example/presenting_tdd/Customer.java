package com.example.presenting_tdd;

import java.util.ArrayList;
import java.util.List;

enum MovieType {
    CHILDRENS,
    REGULAR,
    NEW_RELEASE
}

public class Customer {
    private List<Rental> rentals = new ArrayList<>();

    public void addRental(final String title, final MovieType type, final int daysRented) {
        rentals.add(new Rental(title, type, daysRented));
    }

    public Integer getFrequenceRenterPoints() {
        return rentals.stream()
                .mapToInt(Rental::getFrequenceRenterPoints)
                .sum();
    }

    public Double getCharge() {
        return rentals.stream()
                .mapToDouble(Rental::getCharge)
                .sum();
    }
}
