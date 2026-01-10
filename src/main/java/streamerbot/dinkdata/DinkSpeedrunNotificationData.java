package streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@Data
public class DinkSpeedrunNotificationData extends DinkNotificationData {
    String questName;
    String personalBest;
    String currentTime;
    boolean isPersonalBest;

    public DinkSpeedrunNotificationData() {
        super(DinkNotificationType.SPEEDRUN);
    }
}
