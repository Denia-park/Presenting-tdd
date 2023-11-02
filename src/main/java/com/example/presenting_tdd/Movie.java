package com.example.presenting_tdd;

import jakarta.persistence.*;
import lombok.Getter;

enum MovieType {
    REGULAR,
    NEW_RELEASE,
    CHILDRENS;
}

@Getter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(insertable = false, updatable = false)
    private MovieType type;

    public Movie(final String title) {
        this.title = title;
    }

    public Movie() {
    }

    public Movie(final MovieType movieType, final String childrensMovieTitle) {
        type = movieType;
        title = childrensMovieTitle;
    }

    Double getCharge(final Integer daysRented1, final Rental rental) {
        Double charge = 0.0;
        if (getType() == MovieType.CHILDRENS) {
            charge = 1.5;
            if (daysRented1 > 3) {
                charge += (daysRented1 - 3) * 1.5;
            }
        } else if (getType() == MovieType.REGULAR) {
            charge = 2.0;
            if (daysRented1 > 2) {
                charge += (daysRented1 - 2) * 1.5;
            }
        } else {
            if (getType() == MovieType.NEW_RELEASE) {
                charge = daysRented1 * 3.0;
            }
        }
        return charge;
    }

    Integer getPoints(final Integer daysRented1, final Rental rental) {
        Integer points = 1;
        if (getType() == MovieType.NEW_RELEASE && daysRented1 > 1) {
            points++;
        }
        return points;
    }
}
