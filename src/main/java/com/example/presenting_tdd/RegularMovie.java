package com.example.presenting_tdd;

public class RegularMovie extends Movie {
    public RegularMovie(final String title, final MovieType movieType) {
        super(title, movieType);
    }

    @Override
    public Integer getFrequenceRenterPoints(final int daysRented1) {
        return 1;
    }

    @Override
    public Double getCharge(final int daysRented1) {
        double charge = 2;
        if (daysRented1 > 2) {
            charge += (daysRented1 - 2) * 1.5;
        }

        return charge;
    }
}
