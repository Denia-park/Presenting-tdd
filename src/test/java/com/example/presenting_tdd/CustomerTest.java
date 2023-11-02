package com.example.presenting_tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @Test
    void childrensMovieDaysRentedLTE3() {
        addRentalAndAssertPointsAndCharge("childrenMovie", MovieType.CHILDRENS, 3, 1, 1.5);
    }

    // value based test
    @Test
    void childrensMovieDaysRentedGT3() {
        addRentalAndAssertPointsAndCharge("childrenMovie", MovieType.CHILDRENS, 4, 1, 3.0);
    }

    private void addRentalAndAssertPointsAndCharge(String title, MovieType movieType, final int daysRented, int expectedPoints, final double expectedCharge) {
        customer.addRental(title, movieType, daysRented);
        assertThat(customer.getFrequenceRenterPoints()).isEqualTo(expectedPoints);
        assertThat(customer.getCharge()).isEqualTo(expectedCharge);
    }

    // property based test
    @ParameterizedTest
    @MethodSource("provideMovieAndExpectedValues")
    void addRentalForVariousCase(String title, MovieType movieType, final int daysRented, int expectedPoints, final double expectedCharge) {
        addRentalAndAssertPointsAndCharge(title, movieType, daysRented, expectedPoints, expectedCharge);
    }

    public static Stream<Arguments> provideMovieAndExpectedValues() {
        return Stream.of(
                Arguments.of("childresMovie", MovieType.CHILDRENS, 3, 1, 1.5)
                , Arguments.of("childresMovie", MovieType.CHILDRENS, 4, 1, 3.0)
                , Arguments.of("regularMovie", MovieType.REGULAR, 2, 1, 2.0)
                , Arguments.of("regularMovie", MovieType.REGULAR, 3, 1, 3.5)
                , Arguments.of("newReleaseMovie", MovieType.NEW_RELEASE, 1, 1, 3.0)
                , Arguments.of("newReleaseMovie", MovieType.NEW_RELEASE, 2, 2, 6.0)
        );
    }

    @Test
    void multipleRentals() {
        customer.addRental("tittle", MovieType.CHILDRENS,3);
        customer.addRental("tittle", MovieType.CHILDRENS,4);
        customer.addRental("tittle", MovieType.REGULAR,   2);
        customer.addRental("tittle", MovieType.REGULAR,   3);
        customer.addRental("tittle", MovieType.NEW_RELEASE, 1);
        customer.addRental("tittle", MovieType.NEW_RELEASE, 2);

        assertThat(customer.getFrequenceRenterPoints()).isEqualTo(7);
        assertThat(customer.getCharge()).isEqualTo(19.0);
    }
}

/*
계단테스트 stairstep test
- 필요한 어떤 구조(클래스, 함수 등)를 만들도록 강제하기 위해 작성하는 테스트(canCreateCustomer)
- 이런 테스트는 종종 너무 퇴화해서 단정문이 없을 수 있음
- 나중에 더 포괄적인 테스트로 대체되는 경우가 많으며 안전하게 삭제할 수 있음
- 복잡도를 필요한 수준까지 점진적으로 증가시킬 수 있게 도와주는 계단 역할을 해서 계단테스트라고 함
*/
