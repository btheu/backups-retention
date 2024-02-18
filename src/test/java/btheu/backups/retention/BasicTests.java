package btheu.backups.retention;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

public abstract class BasicTests {

    private List<String> entries;
    private BackupsRetentionEvaluation result;

    @BeforeEach
    void beforeEach() {
        entries = new ArrayList<String>();

    }

    protected void givingEntry(final String entry) {
        entries.add(entry);
    }

    protected void whenRetentionMinute(int minutely, boolean preferRecent) {
        final var rules = BackupsRetentionRules.builder()
                .minutely(minutely)
                .preferRecent(preferRecent)
                .build();

        result = BackupsRetention.evaluate(rules, entries);
    }

    protected void thenKepts(String... entries) {
        assertTrue(result.keptItems().containsAll(Arrays.asList(entries)));
        assertTrue(result.expiredItems().stream().noneMatch(expiredOne -> Arrays.asList(entries).contains(expiredOne)));
    }

}
