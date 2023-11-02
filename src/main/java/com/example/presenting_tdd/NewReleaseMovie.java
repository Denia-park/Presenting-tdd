package com.example.presenting_tdd;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(final String title, final MovieType movieType) {
        super(title, movieType);
    }

    @Override
    public Integer getFrequenceRenterPoints(final int daysRented1) {
        return daysRented1 > 1 ? 2 : 1;
    }

    @Override
    public Double getCharge(final int daysRented1) {
        return (double) (daysRented1 * 3);
    }
}
