package streamerbot;

import streamerbot.dinkdata.DinkNotificationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.externalplugins.ExternalPluginManager;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Slf4j
@Singleton
@RequiredArgsConstructor(onConstructor_ = { @Inject })
public class SettingsManager {
    private final StreamerbotPlugin plugin;
    private final StreamerbotConfig config;
    private final ExternalPluginManager externalPluginManager;
    private final ConfigManager configManager;
    private final Client client;


    public static final String CONFIG_GROUP = "streamerbotplugin";

    public static final String COLLECTION_LOG_ENABLED = "collectionLogEnabled";
    public static final String COLLECTION_LOG_ACTION_NAME = "collectionLogActionName";
    public static final String PETS_ENABLED = "petEnabled";
    public static final String PET_ACTION_NAME = "petActionName";
    public static final String LEVEL_ENABLED = "levelEnabled";
    public static final String LEVEL_ACTION_NAME = "levelActionName";
    public static final String LOOT_ENABLED = "lootEnabled";
    public static final String LOOT_ACTION_NAME = "lootActionName";
    public static final String DEATH_ENABLED = "deathEnabled";
    public static final String DEATH_ACTION_NAME = "deathActionName";
    public static final String SLAYER_ENABLED = "slayerEnabled";
    public static final String SLAYER_ACTION_NAME = "slayerActionName";
    public static final String QUESTS_ENABLED = "questEnabled";
    public static final String QUEST_ACTION_NAME = "questActionName";
    public static final String CLUES_ENABLED = "clueEnabled";
    public static final String CLUE_ACTION_NAME = "clueActionName";
    public static final String SPEEDRUNS_ENABLED = "speedrunEnabled";
    public static final String SPEEDRUN_ACTION_NAME = "speedrunActionName";
    public static final String KILL_COUNT_ENABLED = "killCountEnabled";
    public static final String KILL_COUNT_ACTION_NAME = "killCountActionName";
    public static final String COMBAT_TASK_ENABLED = "combatTaskEnabled";
    public static final String COMBAT_TASK_ACTION_NAME = "combatTaskActionName";
    public static final String DIARY_ENABLED = "diaryEnabled";
    public static final String DIARY_ACTION_NAME = "diaryActionName";
    public static final String GAMBLE_ENABLED = "gambleEnabled";
    public static final String GAMBLE_ACTION_NAME = "gambleActionName";
    public static final String PLAYER_KILLS_ENABLED = "pkEnabled";
    public static final String PLAYER_KILL_ACTION_NAME = "playerKillActionName";
    public static final String GROUP_STORAGE_ENABLED = "groupStorageEnabled";
    public static final String GROUP_STORAGE_ACTION_NAME = "groupStorageActionName";
    public static final String GRAND_EXCHANGE_ENABLED = "notifyGrandExchange";
    public static final String GRAND_EXCHANGE_ACTION_NAME = "grandExchangeActionName";
    public static final String TRADES_ENABLED = "notifyTrades";
    public static final String TRADES_ACTION_NAME = "tradesActionName";
    public static final String CUSTOM_CHAT_ENABLED = "notifyChat";
    public static final String CUSTOM_CHAT_ACTION_NAME = "customChatActionName";
    public static final String EXTERNAL_PLUGIN_REQUESTS_ENABLED = "notifyExternal";
    public static final String EXTERNAL_REQUEST_ACTION_NAME = "externalRequestActionName";
    public static final String LEAGUES_ENABLED = "notifyLeagues";
    public static final String LEAGUES_ACTION_NAME = "leaguesActionName";
    public static final String META_NOTIFIER_ENABLED = "metaNotifierEnabled";
    public static final String META_NOTIFIER_ACTION_NAME = "metaNotifierActionName";

    public static final String DINK_PLUGIN_NAME = "dink";
    public static final String DINK_CONFIG_GROUP = "dinkplugin";
    public static final String RUNELITE_CONFIG_GROUP = "runelite";
    public static final String DINK_METADATA_WEBHOOK_KEY = "metadataWebhook";

    private static final String DINK_NOT_INSTALLED_WARNING = "Dink plugin must be installed and configured.";
    private static final String DINK_DISABLED_WARNING = "Dink plugin must be enabled and configured.";
    private static final String DINK_META_DISABLED_WARNING = "To use this trigger, Dink's 'Custom Metadata Handler" +
             " field in 'Advanced' must be not blank.";
    private static final String DINK_NOTIFIER_NOTICE = "The corresponding Dink notifier has been enabled. " +
            "To set the conditions of this notifier, go to the corresponding notifier's settings in Dink.";

    void checkDinkAndWarn(String key) {
        List<String> plugins = externalPluginManager.getInstalledExternalPlugins();
        if (!plugins.contains(DINK_PLUGIN_NAME)) {
            plugin.addChatWarning(DINK_NOT_INSTALLED_WARNING);
            return;
        }

        boolean dinkEnabled = configManager.getConfiguration(RUNELITE_CONFIG_GROUP, DINK_CONFIG_GROUP, boolean.class);
        if (!dinkEnabled) {
            plugin.addChatWarning(DINK_DISABLED_WARNING);
        }

        if (key.equals(META_NOTIFIER_ENABLED)) {
            checkMetaAndWarn();
        } else {
            checkAndSetNotifier(key);
        }
    }

    /**
     * This approach relies on our key names matching those of Dink plugin.
     */

    void checkAndSetNotifier(String key) {
        String notifierEnabled = configManager.getConfiguration(DINK_CONFIG_GROUP, key);
        if("false".equals(notifierEnabled)) { // notifierEnabled should not be null, but this avoids the null just in case
            configManager.setConfiguration(DINK_CONFIG_GROUP, key, true);
            plugin.addChatNotice(DINK_NOTIFIER_NOTICE);
        }
    }

    void checkMetaAndWarn() {
        String dinkMetadataWebhook = configManager.getConfiguration(DINK_CONFIG_GROUP, DINK_METADATA_WEBHOOK_KEY, String.class);
        if (StringUtils.isBlank(dinkMetadataWebhook)) {
            plugin.addChatWarning(DINK_META_DISABLED_WARNING);
        }
    }

    public void onConfigChanged(ConfigChanged configChanged) {
        String key = configChanged.getKey();
        String value = configChanged.getNewValue();

        if (DinkNotificationType.existsWithEnabledKey(key) && "true".equals(value) && config.warningsEnabled() && client.getGameState() == GameState.LOGGED_IN) {
            checkDinkAndWarn(key);
        }
    }
}
