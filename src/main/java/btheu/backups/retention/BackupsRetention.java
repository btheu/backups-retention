package btheu.backups.retention;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BackupsRetention {

    @Getter
    public static class BackupsRetentionEntry {

        protected Instant timestamp;

        private BackupsRetentionEntry(Instant arg) {
            timestamp = arg;
        }

        public static BackupsRetentionEntry from(String arg) {
            return new BackupsRetentionEntry(null);
        }
    }

    @Getter
    public static class BackupsRetentionEntries {

        final List<BackupsRetentionEntry> entries;

        public BackupsRetentionEntries(List<BackupsRetentionEntry> entries) {
            this.entries = entries;
        }

        public static BackupsRetentionEntries from(List<String> args) {
            final var entries = args.stream().map(BackupsRetentionEntry::from).toList();

            return new BackupsRetentionEntries(entries);
        }
    }

    public static BackupsRetentionEvaluation evaluate(BackupsRetentionRules rules, final List<String> args) {
        final var timestampPattern = rules.getTimestampPattern();
        final BackupsRetentionEntries entries;
        if (Objects.isNull(timestampPattern)) {
            entries = BackupsRetentionEntries.from(args);
        } else {
            log.error("timestamp pattern not implemented");
            entries = null;
        }

        return evaluate(rules, entries);
    }

    private static BackupsRetentionEvaluation evaluate(BackupsRetentionRules rules, BackupsRetentionEntries entries) {
        // TODO Auto-generated method stub
        return null;
    }

}
