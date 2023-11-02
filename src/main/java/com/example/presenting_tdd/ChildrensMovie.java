package com.example.presenting_tdd;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CHILDRENS")
public class ChildrensMovie extends Movie {
    public ChildrensMovie(final MovieType movieType, final String title) {
        super(movieType, title);
    }

    public ChildrensMovie() {
    }

    @Override
    Double getCharge(final Integer daysRented1, final Rental rental) {
        Double charge = 1.5;
        if (daysRented1 > 3) {
            charge += (daysRented1 - 3) * 1.5;
        }
        return charge;
    }

    @Override
    Integer getPoints(final Integer daysRented1, final Rental rental) {
        return 1;
    }
}
