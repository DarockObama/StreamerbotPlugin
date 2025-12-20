package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkQuestNotificationData extends DinkNotificationData {
    String questName;
    int completedQuests = 0;
    int totalQuests = 0;
    int questPoints = 0;
    int totalQuestPoints = 0;

    DinkQuestNotificationData () {
        super("QUEST");
    }
}
