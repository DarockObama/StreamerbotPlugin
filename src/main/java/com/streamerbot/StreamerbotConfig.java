package com.streamerbot;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("StreamerbotPlugin")
public interface StreamerbotConfig extends Config {
    @ConfigItem(
            keyName = "streamerbotAddress",
            name = "Streamerbot address",
            description = "The address of the HTTP server that your Streamerbot instance is running and this plugin will send requests to.",
            position = 0
    )

    default String streamerbotAddress() {
        return "127.0.0.1";
    }

    @ConfigItem(
            keyName = "streamerbotPort",
            name = "Streamerbot port",
            description = "The port number of the HTTP server that your Streamerbot instance is running and this plugin will send requests to.",
            position = 1
    )

    default String streamerbotPort() {
        return "7474";
    }

    @ConfigSection(
            name = "Dink notifications",
            description = "Settings for triggering Streamerbot actions upon Dink notifications",
            position = 2,
            closedByDefault = true
    )

    String dinkNotificationSection = "Dink notifications";

    @ConfigItem(
            keyName = ConfigKeys.COLLECTION_LOG_ENABLED,
            name = "Enable collection log",
            description = "Trigger an action in Streamerbot when Dink fires a collection log notification",
            position = 3,
            section = dinkNotificationSection
    )

    default boolean collectionLogEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.COLLECTION_LOG_ACTION_NAME,
            name = "Collection log action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink collection log notification",
            position= 4,
            section = dinkNotificationSection
    )

    default String collectionLogActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.PETS_ENABLED,
            name = "Enable pets",
            description = "Trigger an action in Streamerbot when Dink fires a pet notification",
            position = 5,
            section = dinkNotificationSection
    )

    default boolean petsEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.PET_ACTION_NAME,
            name = "Pet action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink pet notification",
            position = 6,
            section = dinkNotificationSection
    )

    default String petActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.LEVEL_ENABLED,
            name = "Enable level",
            description = "Trigger an action in Streamerbot when Dink fires a level notification",
            position = 7,
            section = dinkNotificationSection
    )

    default boolean levelEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.LEVEL_ACTION_NAME,
            name = "Level action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink level notification",
            position = 8,
            section = dinkNotificationSection
    )

    default String levelActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.LOOT_ENABLED,
            name = "Enable level",
            description = "Trigger an action in Streamerbot when Dink fires a loot notification",
            position = 9,
            section = dinkNotificationSection
    )

    default boolean lootEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.LOOT_ACTION_NAME,
            name = "Loot action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink loot notification",
            position = 10,
            section = dinkNotificationSection
    )

    default String lootActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.DEATH_ENABLED,
            name = "Enable death",
            description = "Trigger an action in Streamerbot when Dink fires a death notification",
            position = 11,
            section = dinkNotificationSection
    )

    default boolean deathEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.DEATH_ACTION_NAME,
            name = "Death action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink death notification",
            position = 12,
            section = dinkNotificationSection
    )

    default String deathActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.SLAYER_ENABLED,
            name = "Enable slayer",
            description = "Trigger an action in Streamerbot when Dink fires a slayer notification",
            position = 13,
            section = dinkNotificationSection
    )

    default boolean slayerEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.SLAYER_ACTION_NAME,
            name = "Slayer action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink slayer notification",
            position = 14,
            section = dinkNotificationSection
    )

    default String slayerActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.QUESTS_ENABLED,
            name = "Enable quests",
            description = "Trigger an action in Streamerbot when Dink fires a quest notification",
            position = 15,
            section = dinkNotificationSection
    )

    default boolean questsEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.QUEST_ACTION_NAME,
            name = "Quest action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink quest notification",
            position = 16,
            section = dinkNotificationSection
    )

    default String questActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.CLUES_ENABLED,
            name = "Enable clue scrolls",
            description = "Trigger an action in Streamerbot when Dink fires a clue notification",
            position = 17,
            section = dinkNotificationSection
    )

    default boolean cluesEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.CLUE_ACTION_NAME,
            name = "Clue action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink clue notification",
            position = 18,
            section = dinkNotificationSection
    )

    default String clueActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.SPEEDRUNS_ENABLED,
            name = "Enable speedruns",
            description = "Trigger an action in Streamerbot when Dink fires a quest speedrun notification",
            position = 19,
            section = dinkNotificationSection
    )

    default boolean speedrunsEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.SPEEDRUN_ACTION_NAME,
            name = "Speedrun action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink quest speedrun notification",
            position = 20,
            section = dinkNotificationSection
    )

    default String speedrunActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.KILL_COUNT_ENABLED,
            name = "Enable kill count",
            description = "Trigger an action in Streamerbot when Dink fires a kill count notification",
            position = 21,
            section = dinkNotificationSection
    )

    default boolean killCountEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.KILL_COUNT_ACTION_NAME,
            name = "Kill count action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink kill count notification",
            position = 22,
            section = dinkNotificationSection
    )

    default String killCountActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.COMBAT_TASK_ENABLED,
            name = "Enable combat tasks",
            description = "Trigger an action in Streamerbot when Dink fires a combat task notification",
            position = 23,
            section = dinkNotificationSection
    )

    default boolean combatTaskEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.COMBAT_TASK_ACTION_NAME,
            name = "Combat task action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink combat task notification",
            position = 24,
            section = dinkNotificationSection
    )

    default String combatTaskActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.DIARY_ENABLED,
            name = "Enable diary",
            description = "Trigger an action in Streamerbot when Dink fires a achievement diary notification",
            position = 25,
            section = dinkNotificationSection
    )

    default boolean diaryEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.DIARY_ACTION_NAME,
            name = "Diary action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink diary notification",
            position = 26,
            section = dinkNotificationSection
    )

    default String diaryActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.GAMBLE_ENABLED,
            name = "Enable BA gamble",
            description = "Trigger an action in Streamerbot when Dink fires a BA gamble notification",
            position = 27,
            section = dinkNotificationSection
    )

    default boolean gambleEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.GAMBLE_ACTION_NAME,
            name = "BA gamble action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink BA gamble notification",
            position = 28,
            section = dinkNotificationSection
    )

    default String gambleActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.PLAYER_KILLS_ENABLED,
            name = "Enable player kills",
            description = "Trigger an action in Streamerbot when Dink fires a player kill notification",
            position = 29,
            section = dinkNotificationSection
    )

    default boolean playerKillsEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.PLAYER_KILL_ACTION_NAME,
            name = "Player kill action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink player kill notification",
            position = 30,
            section = dinkNotificationSection
    )

    default String playerKillActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.GROUP_STORAGE_ENABLED,
            name = "Enable group storage",
            description = "Trigger an action in Streamerbot when Dink fires a group storage transaction notification",
            position = 31,
            section = dinkNotificationSection
    )

    default boolean Enabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.GROUP_STORAGE_ACTION_NAME,
            name = "Group storage action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink group storage transaction notification",
            position = 32,
            section = dinkNotificationSection
    )

    default String groupStorageActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.GRAND_EXCHANGE_ENABLED,
            name = "Enable GE transactions",
            description = "Trigger an action in Streamerbot when Dink fires a Grand Exchange transaction notification",
            position = 33,
            section = dinkNotificationSection
    )

    default boolean grandExchangeEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.GRAND_EXCHANGE_ACTION_NAME,
            name = "GE transaction action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink Grand Exchange transaction notification",
            position = 34,
            section = dinkNotificationSection
    )

    default String grandExchangeActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.TRADES_ENABLED,
            name = "Enable trades",
            description = "Trigger an action in Streamerbot when Dink fires a trade notification",
            position = 35,
            section = dinkNotificationSection
    )

    default boolean tradesEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.TRADES_ACTION_NAME,
            name = "Trades action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink trade notification",
            position = 36,
            section = dinkNotificationSection
    )

    default String tradesActionName() {
        return "";
    }



    @ConfigItem(
            keyName = ConfigKeys.CUSTOM_CHAT_ENABLED,
            name = "Enable custom chat",
            description = "Trigger an action in Streamerbot when Dink fires a custom chat notification",
            position = 37,
            section = dinkNotificationSection
    )

    default boolean customChatEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.CUSTOM_CHAT_ACTION_NAME,
            name = "Custom chat action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink custom chat notification",
            position = 38,
            section = dinkNotificationSection
    )

    default String customChatActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.EXTERNAL_PLUGIN_REQUESTS_ENABLED,
            name = "Enable external plugin requests",
            description = "Trigger an action in Streamerbot when Dink fires an external plugin notification",
            position = 39,
            section = dinkNotificationSection
    )

    default boolean externalPluginRequestsEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.EXTERNAL_REQUEST_ACTION_NAME,
            name = "External request action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink external plugin notification",
            position = 40,
            section = dinkNotificationSection
    )

    default String externalRequestActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.LEAGUES_ENABLED,
            name = "Enable leagues notifications",
            description = "Trigger an action in Streamerbot when Dink fires a notification for <br/>" +
                    "leagues area unlock, combat mastery unlock, relic unlock, task completion or trophy unlock",
            position = 41,
            section = dinkNotificationSection

    )

    default boolean leaguesEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.LEAGUES_ACTION_NAME,
            name = "Leagues action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink leagues notification",
            position = 42,
            section = dinkNotificationSection
    )

    default String leaguesActionName() {
        return "";
    }

    @ConfigItem(
            keyName = ConfigKeys.META_NOTIFIER_ENABLED,
            name = "Enable meta notifications",
            description = "Trigger an action in Streamerbot when Dink fires login, logout and ToA purple notification <br/>" +
                    "Note: To use this notifier, Dink's 'Custom Metadata Handler' setting in the 'Advanced' section must contain some URL",
            position = 43,
            section = dinkNotificationSection
    )

    default boolean metaNotifierEnabled() {
        return false;
    }

    @ConfigItem(
            keyName = ConfigKeys.META_NOTIFIER_ACTION_NAME,
            name = "Meta notifier action name",
            description = "The exact name of the action to trigger in Streamerbot upon a Dink notification",
            position = 44,
            section = dinkNotificationSection
    )

    default String metaNotifierActionName() {
        return "";
    }
}
