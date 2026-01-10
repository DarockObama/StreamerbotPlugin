package streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkXpNotificationData extends DinkNotificationData {
    Map<String, Integer> xpData;
    Collection<String> milestoneAchieved;
    int interval;

    public DinkXpNotificationData() {
        super(DinkNotificationType.XP_MILESTONE);
    }
}
