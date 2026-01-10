package streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkBossNotificationData extends DinkNotificationData {
    String boss;
    int count;
    String gameMessage;
    String time;
    Boolean isPersonalBest;
    String personalBest;
    Collection<String> party = Collections.emptySet();

    public DinkBossNotificationData() {
        super(DinkNotificationType.KILL_COUNT);
    }
}
