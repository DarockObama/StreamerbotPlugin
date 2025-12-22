package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@EqualsAndHashCode(callSuper = false)
//@Data
public class DinkLeaguesMasteryNotificationData extends DinkNotificationData {
    String masteryType;
    int masteryTier;

    public DinkLeaguesMasteryNotificationData() {
        super(DinkNotificationType.LEAGUES_MASTERY);
    }
}
