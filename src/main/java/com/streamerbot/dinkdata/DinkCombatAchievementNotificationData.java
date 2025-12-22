package com.streamerbot.dinkdata;

import lombok.EqualsAndHashCode;
import lombok.Data;

//@EqualsAndHashCode(callSuper = false)
//@Data
public class DinkCombatAchievementNotificationData extends DinkNotificationData {
    String tier;
    String task;
    int taskPoints;
    int totalPoints;
    int tierProgress = 0;
    int tierTotalPoints = 0;
    int totalPossiblePoints;
    String currentTier = "N/A";
    String nextTier = "N/A";
    String justCompletedTier = "N/A";

    public DinkCombatAchievementNotificationData() {
        super(DinkNotificationType.COMBAT_ACHIEVEMENT);
    }
}
