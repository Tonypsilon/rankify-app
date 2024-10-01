package de.tonypsilon.rankifyapp.application.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PollTest {

    @Test
    void testOptionsUnmodifiable() {
        Option option = new Option("option");
        Poll poll = new Poll(List.of(option), "abc");
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> poll.getOptions().add(new Option("second Option")));
    }

    @Test
    void testVotesUnmodifiable() {
        Vote vote = new Vote();
        Poll poll = new Poll(List.of(new Option("option")), "abc");
        poll.addVote(vote);
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> poll.getVotes().add(new Vote()));
    }

    @Test
    void testPollMustHaveAtLeastOneOption() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Poll(List.of(), "abc"))
                .withMessage("Poll must have at least one option!");
    }

    @Test
    void testMasterSecretMustNotBeBlank() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Poll(List.of(new Option("option")), ""))
                .withMessage("Master secret must not be blank!");
    }

    @Test
    void testIsEncryptedMasterSecret() {
        Poll poll = new Poll(List.of(new Option("option")), "abc");
        assertThat(poll.isEncryptedMasterSecret("abc")).isTrue();
        assertThat(poll.isEncryptedMasterSecret("def")).isFalse();
    }

}