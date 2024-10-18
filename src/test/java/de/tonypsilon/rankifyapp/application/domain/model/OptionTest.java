package de.tonypsilon.rankifyapp.application.domain.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OptionTest {

    @Test
    @SuppressWarnings("ConstantConditions")
    void shouldNotAllowNullName() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new Option(null));
    }

    @Test
    void shouldNotAllowBlankName() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Option(""))
                .withMessage("Option name must not be blank!");
    }
}