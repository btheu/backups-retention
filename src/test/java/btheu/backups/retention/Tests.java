package btheu.backups.retention;

import org.junit.jupiter.api.Test;

public class Tests extends BasicTests {

    @Test
    void minute__001__prefer_recent_Test() {
        givingEntry("abcd__20240101_123000_summary.tgz");
        givingEntry("abcd__20240101_123005_summary.tgz");
        givingEntry("abcd__20240101_123010_summary.tgz");
        givingEntry("abcd__20240101_123015_summary.tgz");

        whenRetentionMinute(2, true);

        thenKepts(
                "abcd__20240101_123010_summary.tgz",
                "abcd__20240101_123015_summary.tgz");
    }

    @Test
    void minute__002__prefer_oldest_Test() {
        givingEntry("abcd__20240101_123000_summary.tgz");
        givingEntry("abcd__20240101_123005_summary.tgz");
        givingEntry("abcd__20240101_123010_summary.tgz");
        givingEntry("abcd__20240101_123015_summary.tgz");

        whenRetentionMinute(2, false);

        thenKepts(
                "abcd__20240101_123000_summary.tgz",
                "abcd__20240101_123005_summary.tgz");
    }

}
