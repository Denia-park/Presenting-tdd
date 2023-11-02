package com.example.presenting_tdd;

public class RentalCalculator {
    public RentalCalculator() {
    }

    RentalResponse getRentalResponse(final Movie movie, final Integer daysRented) {
        final Rental rental = new Rental(movie, daysRented);
        Integer points = 1;
        if (rental.getMovie().getType() == MovieType.NEW_RELEASE && rental.getDaysRented() > 1) {
            points++;
        }

        Double charge = 0.0;
        if (rental.getMovie().getType() == MovieType.CHILDRENS) {
            charge = 1.5;
            if (rental.getDaysRented() > 3) {
                charge += (rental.getDaysRented() - 3) * 1.5;
            }
        } else if (rental.getMovie().getType() == MovieType.REGULAR) {
            charge = 2.0;
            if (rental.getDaysRented() > 2) {
                charge += (rental.getDaysRented() - 2) * 1.5;
            }
        } else {
            if (rental.getMovie().getType() == MovieType.NEW_RELEASE) {
                charge = rental.getDaysRented() * 3.0;
            }
        }
        return new RentalResponse(points, charge);
    }
}
