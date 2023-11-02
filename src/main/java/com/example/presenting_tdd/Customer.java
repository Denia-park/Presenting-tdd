package com.example.presenting_tdd;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Rental> rentals = new ArrayList<>();

    public void addRental(final String title, final Movie.MovieType type, final int daysRented) {
        rentals.add(new Rental(title, type, daysRented));
    }

    public Integer getFrequenceRenterPoints() {
        return rentals.stream()
                .mapToInt(rental -> rental.getFrequenceRenterPoints(rental.daysRented))
                .sum();
    }

    public Double getCharge() {
        return rentals.stream()
                .mapToDouble(rental -> rental.getCharge(rental.daysRented))
                .sum();
    }
}
