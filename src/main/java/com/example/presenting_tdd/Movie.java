package com.example.presenting_tdd;

public class Movie {
    String title;
    MovieType type;

    public Movie() {
    }

    protected Movie(final String title, final MovieType type) {
        this.title = title;
        this.type = type;
    }

    public static Movie of(final String title, final MovieType type) {
        switch (type) {
            case CHILDRENS:
                return new ChildrenMovie(title, MovieType.CHILDRENS);
            case REGULAR:
                return new RegularMovie(title, MovieType.REGULAR);
            case NEW_RELEASE:
                return new NewReleaseMovie(title, MovieType.NEW_RELEASE);
            default:
                throw new IllegalArgumentException("Invalid movie type");
        }
    }

    public Integer getFrequenceRenterPoints(final int daysRented1) {
        if (type == MovieType.NEW_RELEASE && daysRented1 > 1)
            return 2;
        return 1;
    }

    public Double getCharge(final int daysRented1) {
        double charge = 0;
        if (type == MovieType.CHILDRENS) {
            charge = 1.5;
            if (daysRented1 > 3) {
                charge += (daysRented1 - 3) * 1.5;
            }
        } else if (type == MovieType.REGULAR) {
            charge = 2;
            if (daysRented1 > 2) {
                charge += (daysRented1 - 2) * 1.5;
            }
        } else if (type == MovieType.NEW_RELEASE) {
            charge = daysRented1 * 3;
        }
        return charge;
    }

    enum MovieType {
        CHILDRENS,
        REGULAR,
        NEW_RELEASE
    }
}
