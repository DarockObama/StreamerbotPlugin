package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkClueNotificationData extends DinkNotificationData {
    String clueType;
    int numberCompleted;
    Collection<Item> items;

    public DinkClueNotificationData() {
        super(DinkNotificationType.CLUE);
    }
}
