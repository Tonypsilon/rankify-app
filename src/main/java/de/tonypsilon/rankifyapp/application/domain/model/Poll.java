package de.tonypsilon.rankifyapp.application.domain.model;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Poll {

    private final List<Vote> votes;
    private final List<Option> options;
    private final String encryptedMasterSecret;

    public Poll(@Nonnull List<Option> options,
                @Nonnull String encryptedMasterSecret) {
        Objects.requireNonNull(options);
        Objects.requireNonNull(encryptedMasterSecret);
        if(options.isEmpty()) {
            throw new IllegalArgumentException("Poll must have at least one option!");
        }
        if(encryptedMasterSecret.isBlank()) {
            throw new IllegalArgumentException("Master secret must not be blank!");
        }
        this.votes = new ArrayList<>();
        this.options = Collections.unmodifiableList(options);
        this.encryptedMasterSecret = encryptedMasterSecret;
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }

    public List<Option> getOptions() {
        return options;
    }

    public List<Vote> getVotes() {
        return Collections.unmodifiableList(votes);
    }

    public boolean isEncryptedMasterSecret(String otherEncryptedMasterSecret) {
        return encryptedMasterSecret.equals(otherEncryptedMasterSecret);
    }
}
