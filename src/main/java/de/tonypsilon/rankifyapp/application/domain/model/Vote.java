package de.tonypsilon.rankifyapp.application.domain.model;

import java.util.Map;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;

public class Vote {

    private final Poll poll;
    private final Map<Option, Priority> prioritizedOptions;

    public Vote(Poll poll, Map<Option, Priority> prioritizedOptions) {
        validateOptions(poll, prioritizedOptions);
        this.poll = poll;
        this.prioritizedOptions = prioritizedOptions;
    }

    private void validateOptions(Poll poll, Map<Option, Priority> prioritizedOptions) {
        if (!prioritizedOptions.keySet().containsAll(poll.getOptions())) {
            throw new IllegalArgumentException("Vote must contain all options!");
        }
        if (prioritizedOptions.keySet().stream().anyMatch(not(poll.getOptions()::contains))) {
            throw new IllegalArgumentException("Option must belong to vote!");
        }
    }

}
