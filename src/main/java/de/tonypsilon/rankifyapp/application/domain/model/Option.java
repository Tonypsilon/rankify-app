package de.tonypsilon.rankifyapp.application.domain.model;

import javax.annotation.Nonnull;
import java.util.Objects;

public record Option(@Nonnull String name) {
    public Option {
        Objects.requireNonNull(name);
        if (name.isBlank()) {
            throw new IllegalArgumentException("Option name must not be null or blank");
        }
    }
}
