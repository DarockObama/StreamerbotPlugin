package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@EqualsAndHashCode(callSuper = false)
//@Data
public class DinkLeaguesRelicNotificationData extends DinkNotificationData {
    String relic;
    int tier;
    int requiredPoints;
    int totalPoints;

    int pointsUntilNextTier = 0;

    public DinkLeaguesRelicNotificationData() {
        super(DinkNotificationType.LEAGUES_RELIC);
    }
}
