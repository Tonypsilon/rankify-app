package de.tonypsilon.rankifyapp.common.util;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class ListUtil {

    private ListUtil() {
    }

    /**
     * Checks if a list contains duplicates.
     * @param list the list to check
     * @param <T> the type of the list
     * @return true if the list contains duplicates, false otherwise
     */
    public static <T> boolean containsDuplicates(@Nonnull List<T> list) {
        Objects.requireNonNull(list);
        Set<T> set = new HashSet<>();
        for (T t : list) {
            if (!set.add(t)) {
                return true;
            }
        }
        return false;
    }
}
