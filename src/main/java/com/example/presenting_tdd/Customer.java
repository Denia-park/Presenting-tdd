package com.example.presenting_tdd;

enum MovieType {
    CHILDRENS,
    REGULAR,
    NEW_RELEASES
}

public class Customer {
    private int daysRented;

    public void addRental(final String title, final MovieType movieType, final int daysRented) {
        this.daysRented = daysRented;
    }

    public Integer getFrequenceRenterPoints() {
        return 1;
    }

    public Double getCharge() {
        double charge = 1.5;

        if(daysRented > 3) {
            charge += (daysRented - 3) * 1.5;
        }

        return charge;
    }
}
