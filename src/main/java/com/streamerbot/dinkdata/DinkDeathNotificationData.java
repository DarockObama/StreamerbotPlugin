package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Collection;
import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkDeathNotificationData extends DinkNotificationData {

    long valueLost = 0;
    boolean isPvp = false;
    String killerName = "N/A";
    int killerNpcId = 0;
    Collection<Item> keptItems = Collections.emptySet();
    Collection<Item> lostItems = Collections.emptySet();
    Region location;

    public DinkDeathNotificationData() {
        super(DinkNotificationType.DEATH);
    }
}