package com.example.presenting_tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {
    @Test
    void canCreateCustomer() {
        Customer customer = new Customer();

    }

    @Test
    void childrensMovieDaysRentedLTE3() {
        // Arrange
        final Customer c = new Customer();

        // Act
        c.addRental("childresMovie", MovieType.CHILDRENS, 3);

        // Assert
        assertThat(c.getFrequenceRenterPoints()).isEqualTo(1);
        assertThat(c.getCharge()).isEqualTo(1.5);
    }

}
