package com.example.presenting_tdd;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("REGULAR")
public class RegularMovie extends Movie {
    public RegularMovie(final MovieType movieType, final String title) {
        super(movieType, title);
    }

    public RegularMovie() {
    }

    @Override
    Double getCharge(final Integer daysRented1, final Rental rental) {
        Double charge = 2.0;
        if (daysRented1 > 2) {
            charge += (daysRented1 - 2) * 1.5;
        }
        return charge;
    }

    @Override
    Integer getPoints(final Integer daysRented1, final Rental rental) {
        return 1;
    }
}
