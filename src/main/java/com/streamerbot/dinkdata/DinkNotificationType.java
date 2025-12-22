package com.streamerbot.dinkdata;

import lombok.Getter;
import java.util.Map;
import com.streamerbot.ConfigKeys;

@Getter
public enum DinkNotificationType {
    CLUE("CLUE", DinkClueNotificationData.class, ConfigKeys.CLUES_ENABLED, ConfigKeys.CLUE_ACTION_NAME),
    COLLECTION("COLLECTION", DinkCollectionNotificationData.class, ConfigKeys.COLLECTION_LOG_ENABLED, ConfigKeys.COLLECTION_LOG_ACTION_NAME),
    DEATH("DEATH", DinkDeathNotificationData.class, ConfigKeys.DEATH_ENABLED, ConfigKeys.DEATH_ACTION_NAME),
    LEVEL("LEVEL", DinkLevelNotificationData.class,ConfigKeys.LEVEL_ENABLED, ConfigKeys.LEVEL_ACTION_NAME),
    LOOT("LOOT", DinkLootNotificationData.class, ConfigKeys.LOOT_ENABLED, ConfigKeys.LOOT_ACTION_NAME),
    PET("PET", DinkPetNotificationData.class, ConfigKeys.PETS_ENABLED, ConfigKeys.PET_ACTION_NAME),
    QUEST("QUEST", DinkQuestNotificationData.class, ConfigKeys.QUESTS_ENABLED, ConfigKeys.QUEST_ACTION_NAME),
    SLAYER("SLAYER", DinkSlayerNotificationData.class, ConfigKeys.SLAYER_ENABLED, ConfigKeys.SLAYER_ACTION_NAME),
    SPEEDRUN("SPEEDRUN", DinkSpeedrunNotificationData.class, ConfigKeys.SPEEDRUNS_ENABLED, ConfigKeys.SPEEDRUN_ACTION_NAME),
    KILL_COUNT("KILL_COUNT", DinkBossNotificationData.class, ConfigKeys.KILL_COUNT_ENABLED, ConfigKeys.KILL_COUNT_ACTION_NAME),
    COMBAT_ACHIEVEMENT("COMBAT_ACHIEVEMENT", DinkCombatAchievementNotificationData.class, ConfigKeys.COMBAT_TASK_ENABLED, ConfigKeys.COMBAT_TASK_ACTION_NAME),
    ACHIEVEMENT_DIARY("ACHIEVEMENT_DIARY", DinkDiaryNotificationData.class, ConfigKeys.DIARY_ENABLED, ConfigKeys.DIARY_ACTION_NAME),
    BARBARIAN_ASSAULT_GAMBLE("BARBARIAN_ASSAULT_GAMBLE", DinkGambleNotificationData.class, ConfigKeys.GAMBLE_ENABLED, ConfigKeys.GAMBLE_ACTION_NAME),
    PLAYER_KILL("PLAYER_KILL", DinkPlayerKillNotificationData.class, ConfigKeys.PLAYER_KILLS_ENABLED, ConfigKeys.PLAYER_KILL_ACTION_NAME),
    GROUP_STORAGE("GROUP_STORAGE", DinkGroupStorageNotificationData.class, ConfigKeys.GROUP_STORAGE_ENABLED, ConfigKeys.GROUP_STORAGE_ACTION_NAME),
    GRAND_EXCHANGE("GRAND_EXCHANGE", DinkGrandExchangeNotificationData.class, ConfigKeys.GRAND_EXCHANGE_ENABLED, ConfigKeys.GROUP_STORAGE_ACTION_NAME),
    LEAGUES_AREA("LEAGUES_AREA", DinkLeaguesAreaNotificationData.class, ConfigKeys.LEAGUES_ENABLED, ConfigKeys.LEAGUES_ACTION_NAME),
    LEAGUES_MASTERY("LEAGUES_MASTERY", DinkLeaguesMasteryNotificationData.class, ConfigKeys.LEAGUES_ENABLED, ConfigKeys.LEAGUES_ACTION_NAME),
    LEAGUES_RELIC("LEAGUES_RELIC", DinkLeaguesRelicNotificationData.class, ConfigKeys.LEAGUES_ENABLED, ConfigKeys.LEAGUES_ACTION_NAME),
    LEAGUES_TASK("LEAGUES_TASK", DinkLeaguesTaskNotificationData.class, ConfigKeys.LEAGUES_ENABLED, ConfigKeys.LEAGUES_ACTION_NAME),
    LOGIN("LOGIN", DinkLoginNotificationData.class, ConfigKeys.META_NOTIFIER_ENABLED, ConfigKeys.META_NOTIFIER_ACTION_NAME),
    //LOGOUT("LOGOUT"), Not sent by dink as PluginMessage, may need
    TOA_UNIQUE("TOA_UNIQUE", DinkAmascutPurpleNotificationData.class, ConfigKeys.META_NOTIFIER_ENABLED, ConfigKeys.META_NOTIFIER_ACTION_NAME),
    TRADE("TRADE", DinkTradeNotificationData.class, ConfigKeys.TRADES_ENABLED, ConfigKeys.TRADES_ACTION_NAME),
    CHAT("CHAT", DinkChatNotificationData.class, ConfigKeys.CUSTOM_CHAT_ENABLED, ConfigKeys.CUSTOM_CHAT_ACTION_NAME),
    XP_MILESTONE("XP_MILESTONE", DinkXpNotificationData.class, ConfigKeys.LEVEL_ENABLED,ConfigKeys.LEVEL_ACTION_NAME),
    EXTERNAL_PLUGIN("EXTERNAL_PLUGIN", DinkExternalNotificationData.class, ConfigKeys.EXTERNAL_PLUGIN_REQUESTS_ENABLED, ConfigKeys.EXTERNAL_REQUEST_ACTION_NAME),

    //acts as fallback
    UNKNOWN("UNKNOWN");

    private final String type;
    private final Class<? extends DinkNotificationData> dataClass;
    private final String enabledKey;
    private final String actionKey;

    DinkNotificationType(String type) {
        this.type = type;
        this.dataClass = DinkNotificationData.class;
        this.enabledKey = null;
        this.actionKey = null;
    }

    DinkNotificationType(String type, Class<? extends DinkNotificationData> dataClass, String enabledKey, String actionKey) {
        this.type = type;
        this.dataClass = dataClass;
        this.enabledKey = enabledKey;
        this.actionKey = actionKey;
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