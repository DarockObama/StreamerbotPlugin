package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.kit.KitType;

import java.util.Map;


//@EqualsAndHashCode(callSuper = false)
//@Data
public class DinkPlayerKillNotificationData extends DinkNotificationData {
    String victimName;
    int victimCombatLevel;
    Map<KitType, Item> victimEquipment;
    int world = 0;
    WorldPoint location;
    int myHitpoints;
    int myLastDamage;

    DinkPlayerKillNotificationData() {
        super(DinkNotificationType.PLAYER_KILL);
    }
}
