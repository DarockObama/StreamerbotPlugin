package streamerbot.dinkdata;

import lombok.Getter;
import java.util.Map;
import streamerbot.SettingsManager;

@Getter
public enum DinkNotificationType {
    CLUE("CLUE", DinkClueNotificationData.class, SettingsManager.CLUES_ENABLED, SettingsManager.CLUE_ACTION_NAME),
    COLLECTION("COLLECTION", DinkCollectionNotificationData.class, SettingsManager.COLLECTION_LOG_ENABLED, SettingsManager.COLLECTION_LOG_ACTION_NAME),
    DEATH("DEATH", DinkDeathNotificationData.class, SettingsManager.DEATH_ENABLED, SettingsManager.DEATH_ACTION_NAME),
    LEVEL("LEVEL", DinkLevelNotificationData.class, SettingsManager.LEVEL_ENABLED, SettingsManager.LEVEL_ACTION_NAME),
    LOOT("LOOT", DinkLootNotificationData.class, SettingsManager.LOOT_ENABLED, SettingsManager.LOOT_ACTION_NAME),
    PET("PET", DinkPetNotificationData.class, SettingsManager.PETS_ENABLED, SettingsManager.PET_ACTION_NAME),
    QUEST("QUEST", DinkQuestNotificationData.class, SettingsManager.QUESTS_ENABLED, SettingsManager.QUEST_ACTION_NAME),
    SLAYER("SLAYER", DinkSlayerNotificationData.class, SettingsManager.SLAYER_ENABLED, SettingsManager.SLAYER_ACTION_NAME),
    SPEEDRUN("SPEEDRUN", DinkSpeedrunNotificationData.class, SettingsManager.SPEEDRUNS_ENABLED, SettingsManager.SPEEDRUN_ACTION_NAME),
    KILL_COUNT("KILL_COUNT", DinkBossNotificationData.class, SettingsManager.KILL_COUNT_ENABLED, SettingsManager.KILL_COUNT_ACTION_NAME),
    COMBAT_ACHIEVEMENT("COMBAT_ACHIEVEMENT", DinkCombatAchievementNotificationData.class, SettingsManager.COMBAT_TASK_ENABLED, SettingsManager.COMBAT_TASK_ACTION_NAME),
    ACHIEVEMENT_DIARY("ACHIEVEMENT_DIARY", DinkDiaryNotificationData.class, SettingsManager.DIARY_ENABLED, SettingsManager.DIARY_ACTION_NAME),
    BARBARIAN_ASSAULT_GAMBLE("BARBARIAN_ASSAULT_GAMBLE", DinkGambleNotificationData.class, SettingsManager.GAMBLE_ENABLED, SettingsManager.GAMBLE_ACTION_NAME),
    PLAYER_KILL("PLAYER_KILL", DinkPlayerKillNotificationData.class, SettingsManager.PLAYER_KILLS_ENABLED, SettingsManager.PLAYER_KILL_ACTION_NAME),
    GROUP_STORAGE("GROUP_STORAGE", DinkGroupStorageNotificationData.class, SettingsManager.GROUP_STORAGE_ENABLED, SettingsManager.GROUP_STORAGE_ACTION_NAME),
    GRAND_EXCHANGE("GRAND_EXCHANGE", DinkGrandExchangeNotificationData.class, SettingsManager.GRAND_EXCHANGE_ENABLED, SettingsManager.GROUP_STORAGE_ACTION_NAME),
    LEAGUES_AREA("LEAGUES_AREA", DinkLeaguesAreaNotificationData.class, SettingsManager.LEAGUES_ENABLED, SettingsManager.LEAGUES_ACTION_NAME),
    LEAGUES_MASTERY("LEAGUES_MASTERY", DinkLeaguesMasteryNotificationData.class, SettingsManager.LEAGUES_ENABLED, SettingsManager.LEAGUES_ACTION_NAME),
    LEAGUES_RELIC("LEAGUES_RELIC", DinkLeaguesRelicNotificationData.class, SettingsManager.LEAGUES_ENABLED, SettingsManager.LEAGUES_ACTION_NAME),
    LEAGUES_TASK("LEAGUES_TASK", DinkLeaguesTaskNotificationData.class, SettingsManager.LEAGUES_ENABLED, SettingsManager.LEAGUES_ACTION_NAME),
    LOGIN("LOGIN", DinkLoginNotificationData.class, SettingsManager.META_NOTIFIER_ENABLED, SettingsManager.META_NOTIFIER_ACTION_NAME),
    TOA_UNIQUE("TOA_UNIQUE", DinkAmascutPurpleNotificationData.class, SettingsManager.META_NOTIFIER_ENABLED, SettingsManager.META_NOTIFIER_ACTION_NAME),
    TRADE("TRADE", DinkTradeNotificationData.class, SettingsManager.TRADES_ENABLED, SettingsManager.TRADES_ACTION_NAME),
    CHAT("CHAT", DinkChatNotificationData.class, SettingsManager.CUSTOM_CHAT_ENABLED, SettingsManager.CUSTOM_CHAT_ACTION_NAME),
    XP_MILESTONE("XP_MILESTONE", DinkXpNotificationData.class, SettingsManager.LEVEL_ENABLED, SettingsManager.LEVEL_ACTION_NAME),
    EXTERNAL_PLUGIN("EXTERNAL_PLUGIN", DinkExternalNotificationData.class, SettingsManager.EXTERNAL_PLUGIN_REQUESTS_ENABLED, SettingsManager.EXTERNAL_REQUEST_ACTION_NAME),

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
        if (name == null) return UNKNOWN;
        return BY_TYPE.getOrDefault(name, UNKNOWN);
    }

    public static boolean existsWithEnabledKey(String enabledKey) {
        if(enabledKey == null) return false;
        for(DinkNotificationType type : values()) {
            if(type == UNKNOWN) continue;
            if(enabledKey.equals(type.enabledKey)) {
                return true;
            }
        }

        return false;
    }
}