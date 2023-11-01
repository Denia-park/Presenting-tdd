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

/*
계단테스트 stairstep test
- 필요한 어떤 구조(클래스, 함수 등)를 만들도록 강제하기 위해 작성하는 테스트(canCreateCustomer)
- 이런 테스트는 종종 너무 퇴화해서 단정문이 없을 수 있음
- 나중에 더 포괄적인 테스트로 대체되는 경우가 많으며 안전하게 삭제할 수 있음
- 복잡도를 필요한 수준까지 점진적으로 증가시킬 수 있게 도와주는 계단 역할을 해서 계단테스트라고 함
*/
