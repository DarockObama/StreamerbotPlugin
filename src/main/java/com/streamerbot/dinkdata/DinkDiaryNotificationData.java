package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkDiaryNotificationData extends DinkNotificationData {
    String area;
    String difficulty;
    int total;
    int tasksCompleted;
    int tasksTotal;
    int areaTasksCompleted;
    int areaTasksTotal;

    public DinkDiaryNotificationData() {
        super(DinkNotificationType.ACHIEVEMENT_DIARY);
    }
}
