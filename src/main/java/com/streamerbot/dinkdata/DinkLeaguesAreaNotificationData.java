package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLeaguesAreaNotificationData extends DinkNotificationData {
    String area;
    int index;
    int tasksCompleted;
    int tasksUntilNextArea = 0;

    public DinkLeaguesAreaNotificationData() {
        super(DinkNotificationType.LEAGUES_AREA);
    }
}
