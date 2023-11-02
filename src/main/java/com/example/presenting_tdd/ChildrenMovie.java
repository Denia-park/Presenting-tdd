package com.example.presenting_tdd;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(final String title, final MovieType movieType) {
        super(title, movieType);
    }

    @Override
    public Integer getFrequenceRenterPoints(final int daysRented1) {
        return 1;
    }

    @Override
    public Double getCharge(final int daysRented1) {
        double charge = 1.5;
        if (daysRented1 > 3) {
            charge += (daysRented1 - 3) * 1.5;
        }

        return charge;
    }
}
