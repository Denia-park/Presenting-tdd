package com.example.presenting_tdd;

public class Rental {
    Movie movie;
    int daysRented;

    public Rental() {
    }

    public Rental(final String title, final Movie.MovieType type, final int daysRented) {
        this.movie = new Movie(title, type);
        this.daysRented = daysRented;
    }

    public void addRental(final String title, final Movie.MovieType type, final int daysRented) {
        this.movie.type = type;
        this.daysRented = daysRented;
    }

    public Integer getFrequenceRenterPoints(final int daysRented1) {
        return movie.getFrequenceRenterPoints(daysRented1);
    }

    public Double getCharge(final int daysRented1) {
        return movie.getCharge(daysRented1);
    }

}
