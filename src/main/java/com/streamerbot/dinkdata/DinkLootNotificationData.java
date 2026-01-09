package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLootNotificationData extends DinkNotificationData {
    Collection<Loot> items;
    String source;
    Collection<String> party = Collections.emptySet();
    String category;
    int killCount = 0;
    Double rarestProbability = 0.0;
    int npcId = 0;

    public DinkLootNotificationData() {
        super(DinkNotificationType.LOOT);
    }
}