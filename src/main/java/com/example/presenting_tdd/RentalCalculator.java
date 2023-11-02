package com.example.presenting_tdd;

public class RentalCalculator {
    public RentalCalculator() {
    }

    RentalResponse getRentalResponse(final Movie movie, final Integer daysRented) {
        final Rental rental = new Rental(movie, daysRented);
        return new RentalResponse(rental.movie.getPoints(rental.getDaysRented(), rental), rental.movie.getCharge(rental.getDaysRented(), rental));
    }

}
