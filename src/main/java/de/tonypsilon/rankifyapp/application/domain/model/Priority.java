package de.tonypsilon.rankifyapp.application.domain.model;

import java.util.Objects;
import java.util.Optional;

public record Priority(Optional<Integer> value) {
    public Priority {
        Objects.requireNonNull(value);
        if (value.isPresent() && (value.get() < 1 )) {
            throw new IllegalArgumentException("Priority value must be positive!");
        }
    }
}
