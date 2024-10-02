package de.tonypsilon.rankifyapp.application.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CreatePollDataTest {

    @Test
    @SuppressWarnings("ConstantConditions")
    void testOptionsNotNull() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new CreatePollData(null, "name", "abc"))
                .withMessage("Options must not be null!");
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void testNameNotNull() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new CreatePollData(List.of(new Option("option")), null, "abc"))
                .withMessage("Poll name must not be null!");
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void testMasterSecretNotNull() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> new CreatePollData(List.of(new Option("option")), "name", null))
                .withMessage("Master secret must not be null!");
    }

    @Test
    void testPollMustHaveAtLeastOneOption() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CreatePollData(List.of(), "name", "abc"))
                .withMessage("Poll must have at least one option!");
    }

    @Test
    void testPollNameMustNotBeBlank() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CreatePollData(List.of(new Option("option")), "", "abc"))
                .withMessage("Poll name must not be blank!");
    }

    @Test
    void testMasterSecretMustNotBeBlank() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CreatePollData(List.of(new Option("option")), "name", ""))
                .withMessage("Master secret must not be blank!");
    }
}