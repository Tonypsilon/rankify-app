package de.tonypsilon.rankifyapp.common.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static de.tonypsilon.rankifyapp.common.util.ListUtil.containsDuplicates;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ListUtilTest {

    @Test
    void testContainsDuplicatesWithDuplicates() {
        List<String> listWithDuplicates = List.of("a", "b", "a");
        assertThat(containsDuplicates(listWithDuplicates)).isTrue();
    }

    @Test
    void testContainsDuplicatesWithoutDuplicates() {
        List<String> listWithoutDuplicates = List.of("a", "b", "c");
        assertThat(containsDuplicates(listWithoutDuplicates)).isFalse();
    }

    @Test
    void testContainsDuplicatesWithEmptyList() {
        List<String> emptyList = List.of();
        assertThat(containsDuplicates(emptyList)).isFalse();
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void testContainsDuplicatesWithNullList() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> containsDuplicates(null));
    }
}