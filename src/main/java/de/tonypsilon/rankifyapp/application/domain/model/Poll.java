package de.tonypsilon.rankifyapp.application.domain.model;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Poll {

    private final List<Vote> votes;
    private final List<Option> options;
    private final String name;
    private final String encryptedMasterSecret;

    public Poll(@Nonnull CreatePollData createPollData) {
        Objects.requireNonNull(createPollData, "InputData must not be null!");
        this.votes = new ArrayList<>();
        this.name = createPollData.name();
        this.options = Collections.unmodifiableList(createPollData.options());
        this.encryptedMasterSecret = createPollData.encryptedMasterSecret();
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

    public String getName() {
        return name;
    }
}
