package de.tonypsilon.rankifyapp.application.domain.model;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

public record CreatePollData(@Nonnull List<Option> options,
                             @Nonnull String name,
                             @Nonnull String encryptedMasterSecret) {
    public CreatePollData {
        Objects.requireNonNull(options, "Options must not be null!");
        Objects.requireNonNull(name, "Poll name must not be null!");
        Objects.requireNonNull(encryptedMasterSecret, "Master secret must not be null!");
        if (options.isEmpty()) {
            throw new IllegalArgumentException("Poll must have at least one option!");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Poll name must not be blank!");
        }
        if (encryptedMasterSecret.isBlank()) {
            throw new IllegalArgumentException("Master secret must not be blank!");
        }
    }
}
