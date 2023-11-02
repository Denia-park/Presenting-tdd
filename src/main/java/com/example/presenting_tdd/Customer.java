package com.example.presenting_tdd;

enum MovieType {
    CHILDRENS,
    REGULAR,
    NEW_RELEASE
}

public class Customer {
    private Rental rental;

    public void addRental(final String title, final MovieType type, final int daysRented) {
        rental = new Rental(title, type, daysRented);
    }

    public Integer getFrequenceRenterPoints() {
        return rental.getFrequenceRenterPoints();
    }

    public Double getCharge() {
        return rental.getCharge();
    }
}
