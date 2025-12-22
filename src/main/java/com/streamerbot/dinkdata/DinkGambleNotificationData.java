package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

//@EqualsAndHashCode(callSuper = false)
//@Data
public class DinkGambleNotificationData extends DinkNotificationData {
    int gambleCount;
    List<Item> items;

    public DinkGambleNotificationData() {
        super(DinkNotificationType.BARBARIAN_ASSAULT_GAMBLE);
    }
}
