package com.streamerbot;

import com.streamerbot.dinkdata.DinkNotificationType;
import com.streamerbot.util.KeyFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.externalplugins.ExternalPluginManager;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Slf4j
@Singleton
@RequiredArgsConstructor(onConstructor_ = { @Inject })
public class SettingsManager {
    private final StreamerbotPlugin plugin;
    private final ExternalPluginManager externalPluginManager;

    public static final String CONFIG_GROUP = "StreamerbotPlugin";

    public static final String COLLECTION_LOG_ENABLED = "collectionLogEnabled";
    public static final String COLLECTION_LOG_ACTION_NAME = "collectionLogActionName";
    public static final String PETS_ENABLED = "petsEnabled";
    public static final String PET_ACTION_NAME = "petActionName";
    public static final String LEVEL_ENABLED = "levelEnabled";
    public static final String LEVEL_ACTION_NAME = "levelActionName";
    public static final String LOOT_ENABLED = "lootEnabled";
    public static final String LOOT_ACTION_NAME = "lootActionName";
    public static final String DEATH_ENABLED = "deathEnabled";
    public static final String DEATH_ACTION_NAME = "deathActionName";
    public static final String SLAYER_ENABLED = "slayerEnabled";
    public static final String SLAYER_ACTION_NAME = "slayerActionName";
    public static final String QUESTS_ENABLED = "questsEnabled";
    public static final String QUEST_ACTION_NAME = "questActionName";
    public static final String CLUES_ENABLED = "cluesEnabled";
    public static final String CLUE_ACTION_NAME = "clueActionName";
    public static final String SPEEDRUNS_ENABLED = "speedrunsEnabled";
    public static final String SPEEDRUN_ACTION_NAME = "speedrunActionName";
    public static final String KILL_COUNT_ENABLED = "killCountEnabled";
    public static final String KILL_COUNT_ACTION_NAME = "killCountActionName";
    public static final String COMBAT_TASK_ENABLED = "combatTaskEnabled";
    public static final String COMBAT_TASK_ACTION_NAME = "combatTaskActionName";
    public static final String DIARY_ENABLED = "diaryEnabled";
    public static final String DIARY_ACTION_NAME = "diaryActionName";
    public static final String GAMBLE_ENABLED = "gambleEnabled";
    public static final String GAMBLE_ACTION_NAME = "gambleActionName";
    public static final String PLAYER_KILLS_ENABLED = "playerKillsEnabled";
    public static final String PLAYER_KILL_ACTION_NAME = "playerKillActionName";
    public static final String GROUP_STORAGE_ENABLED = "groupStorageEnabled";
    public static final String GROUP_STORAGE_ACTION_NAME = "groupStorageActionName";
    public static final String GRAND_EXCHANGE_ENABLED = "grandExchangeEnabled";
    public static final String GRAND_EXCHANGE_ACTION_NAME = "grandExchangeActionName";
    public static final String TRADES_ENABLED = "tradesEnabled";
    public static final String TRADES_ACTION_NAME = "tradesActionName";
    public static final String CUSTOM_CHAT_ENABLED = "customChatEnabled";
    public static final String CUSTOM_CHAT_ACTION_NAME = "customChatActionName";
    public static final String EXTERNAL_PLUGIN_REQUESTS_ENABLED = "externalPluginRequestsEnabled";
    public static final String EXTERNAL_REQUEST_ACTION_NAME = "externalRequestActionName";
    public static final String LEAGUES_ENABLED = "leaguesEnabled";
    public static final String LEAGUES_ACTION_NAME = "leaguesActionName";
    public static final String META_NOTIFIER_ENABLED = "metaNotifierEnabled";
    public static final String META_NOTIFIER_ACTION_NAME = "metaNotifierActionName";

    public static final String DINK_PLUGIN_NAME = "dink";


    public void init() {
        List<String> plugins = externalPluginManager.getInstalledExternalPlugins();
        if(!plugins.contains(DINK_PLUGIN_NAME)) {

        }
    }

    public void onConfigChanged(ConfigChanged configChanged) {
        if(!configChanged.getGroup().equals(CONFIG_GROUP)) {
            return;
        }


        String key = configChanged.getKey();
        String value = configChanged.getNewValue();

        if(!DinkNotificationType.existsWithEnabledKey(key)) {
            log.debug("Not a Dink notification enabled setting, returning");
            return;
        }

        if("true".equals(value)) {
            String notifier = KeyFormatter.toReadableName((key));
            plugin.addChatWarning("To use this trigger, make sure " + notifier + " notifications are configured correctly in Dink Plugin");
        }
    }
}
