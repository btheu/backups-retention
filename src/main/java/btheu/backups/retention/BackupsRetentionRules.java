package btheu.backups.retention;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;

@Getter
@Builder
public class BackupsRetentionRules {

    protected int minutely;
    protected int hourly;
    protected int daily;
    protected int weekly;
    protected int monthly;
    protected int yearly;

    protected String timestampPattern;
    protected String includePattern;
    protected String excludePattern;

    @Default
    protected boolean preferRecent = false;
}
