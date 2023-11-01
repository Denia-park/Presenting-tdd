package com.example.presenting_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @Test
    void childrensMovieDaysRentedLTE3() {
        // Arrange

        // Act
        customer.addRental("childresMovie", MovieType.CHILDRENS, 3);

        // Assert
        assertThat(customer.getFrequenceRenterPoints()).isEqualTo(1);
        assertThat(customer.getCharge()).isEqualTo(1.5);
    }

}
