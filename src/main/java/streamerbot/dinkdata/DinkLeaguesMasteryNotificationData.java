package streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLeaguesMasteryNotificationData extends DinkNotificationData {
    String masteryType;
    int masteryTier;

    public DinkLeaguesMasteryNotificationData() {
        super(DinkNotificationType.LEAGUES_MASTERY);
    }
}
