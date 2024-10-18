package de.tonypsilon.rankifyapp.application.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;

class PollTest {

    @Test
    void testOptionsUnmodifiable() {
        Option option = new Option("option");
        Poll poll = new Poll(new CreatePollData(List.of(option), "name", "abc"));
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> poll.getOptions().add(new Option("second Option")));
    }

    @Test
    void testVotesUnmodifiable() {
        Vote vote = mock(Vote.class);
        Poll poll = new Poll(new CreatePollData(List.of(new Option("option")), "name", "abc"));
        poll.addVote(vote);
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> poll.getVotes().add(mock(Vote.class)));
    }

    @Test
    void testIsEncryptedMasterSecret() {
        Poll poll = new Poll(new CreatePollData(List.of(new Option("option")), "name", "abc"));
        assertThat(poll.isEncryptedMasterSecret("abc")).isTrue();
        assertThat(poll.isEncryptedMasterSecret("def")).isFalse();
    }

}