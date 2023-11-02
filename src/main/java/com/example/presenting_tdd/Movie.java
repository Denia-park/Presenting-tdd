package com.example.presenting_tdd;

public class Movie {
    String title;
    MovieType type;

    public Movie() {
    }

    public Integer getFrequenceRenterPoints(final int daysRented1) {
        if (type == MovieType.NEW_RELEASE && daysRented1 > 1)
            return 2;
        return 1;
    }

    public Double getCharge(final int daysRented1) {
        double charge = 0;
        if (type == MovieType.CHILDRENS) {
            charge = 1.5;
            if (daysRented1 > 3) {
                charge += (daysRented1 - 3) * 1.5;
            }
        } else if (type == MovieType.REGULAR) {
            charge = 2;
            if (daysRented1 > 2) {
                charge += (daysRented1 - 2) * 1.5;
            }
        } else if (type == MovieType.NEW_RELEASE) {
            charge = daysRented1 * 3;
        }
        return charge;
    }

    enum MovieType {
        CHILDRENS,
        REGULAR,
        NEW_RELEASE
    }
}
