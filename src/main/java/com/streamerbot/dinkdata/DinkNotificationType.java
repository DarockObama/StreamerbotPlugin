package com.streamerbot.dinkdata;

import lombok.Getter;
import java.util.Map;

@Getter
public enum DinkNotificationType {
    CLUE("CLUE"),
    COLLECTION("COLLECTION", DinkCollectionNotificationData.class),
    DEATH("DEATH", DinkDeathNotificationData.class),
    LEVEL("LEVEL"),
    LOOT("LOOT"),
    PET("PET"),
    QUEST("QUEST"),
    SLAYER("SLAYER"),
    SPEEDRUN("SPEEDRUN"),
    KILL_COUNT("KILL_COUNT"),
    COMBAT_ACHIEVEMENT("COMBAT_ACHIEVEMENT"),
    ACHIEVEMENT_DIARY("ACHIEVEMENT_DIARY"),
    BARBARIAN_ASSAULT_GAMBLE("BARBARIAN_ASSAULT_GAMBLE"),
    PLAYER_KILL("PLAYER_KILL"),
    GROUP_STORAGE("GROUP_STORAGE"),
    GRAND_EXCHANGE("GRAND_EXCHANGE"),
    LEAGUES_AREA("LEAGUES_AREA"),
    LEAGUES_MASTERY("LEAGUES_MASTERY"),
    LEAGUES_RELIC("LEAGUES_RELIC"),
    LEAGUES_TASK("LEAGUES_TASK"),
    LOGIN("LOGIN"),
    LOGOUT("LOGOUT"),
    TOA_UNIQUE("TOA_UNIQUE"),
    TRADE("TRADE"),
    CHAT("CHAT"),
    XP_MILESTONE("XP_MILESTONE"),
    EXTERNAL_PLUGIN("EXTERNAL_PLUGIN"),

    //acts as fallback
    UNKNOWN("UNKNOWN");

    private final String type;
    private final Class<? extends DinkNotificationData> dataClass;
    private final String enabledKey;
    private final String actionKey;

    DinkNotificationType(String type) {
        this.type = type;
        this.dataClass = DinkNotificationData.class;
    }

    DinkNotificationType(String type, Class<? extends DinkNotificationData> dataClass) {
        this.type = type;
        this.dataClass = dataClass;
    }

    private static final Map<String, DinkNotificationType> BY_TYPE =
            java.util.Arrays.stream(values())
                    .collect(java.util.stream.Collectors.toUnmodifiableMap(
                            DinkNotificationType::getType,
                            e -> e
                    ));

    public static DinkNotificationType fromName(String name) {
        if (name == null) return null;
        return BY_TYPE.getOrDefault(name, UNKNOWN);
    }
}