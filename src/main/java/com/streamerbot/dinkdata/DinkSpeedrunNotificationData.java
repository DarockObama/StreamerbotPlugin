package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@EqualsAndHashCode(callSuper = false)
//@Data
public class DinkSpeedrunNotificationData extends DinkNotificationData {
    String questName;
    String personalBest;
    String currentTime;
    boolean isPersonalBest;

    public DinkSpeedrunNotificationData() {
        super(DinkNotificationType.SPEEDRUN);
    }
}
