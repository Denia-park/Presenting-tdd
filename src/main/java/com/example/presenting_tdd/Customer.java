package com.example.presenting_tdd;

enum MovieType {
    CHILDRENS,
    REGULAR,
    NEW_RELEASES
}

public class Customer {

    public void addRental(final String title, final MovieType movieType, final int days) {
    }

    public Integer getFrequenceRenterPoints() {
        return 1;
    }

    public Double getCharge() {
        return 1.5;
    }
}
