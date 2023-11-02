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
public abstract class Movie {
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

    abstract Double getCharge(Integer daysRented1, Rental rental);

    abstract Integer getPoints(Integer daysRented1, Rental rental);
}
