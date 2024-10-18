package de.tonypsilon.rankifyapp.application.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PriorityTest {

    @Test
    @SuppressWarnings("ConstantConditions")
    void shouldNotAllowNullValue() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Priority(null));
    }

    @Test
    void shouldNotAllowNegativeValue() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Priority(Optional.of(-1)))
                .withMessage("Priority value must be positive!");
    }

    @Test
    void shouldNotAllowZeroValue() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Priority(Optional.of(0)))
                .withMessage("Priority value must be positive!");
    }
}