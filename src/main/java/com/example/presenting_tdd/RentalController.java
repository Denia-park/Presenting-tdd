package com.example.presenting_tdd;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final MovieRepository movieRepository;

    public RentalController(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public Movie getRentals(@RequestParam String title) {
        return movieRepository.findByTitle(title);
    }

    @PostMapping
    public RentalResponse addRental(@RequestBody RentalRequest rentalRequest) {
        Movie movie = movieRepository.findByTitle(rentalRequest.title());

        Integer points = 1;
        if (movie.getType() == MovieType.NEW_RELEASE && rentalRequest.daysRented() > 1) {
            points++;
        }

        Double charge = 0.0;
        if(movie.getType() == MovieType.CHILDRENS) {
            charge = 1.5;
            if (rentalRequest.daysRented() > 3) {
                charge += (rentalRequest.daysRented() - 3) * 1.5;
            }
        }
        else if(movie.getType() == MovieType.REGULAR) {
            charge = 2.0;
            if (rentalRequest.daysRented() > 2) {
                charge += (rentalRequest.daysRented() - 2) * 1.5;
            }
        }
        else if(movie.getType() == MovieType.NEW_RELEASE) {
            charge = rentalRequest.daysRented() * 3.0;
        }
        return new RentalResponse(points, charge);
    }
}

record RentalRequest(String title, Integer daysRented) {
}

record RentalResponse(Integer frequentRentalPoints, Double charge) {
}
