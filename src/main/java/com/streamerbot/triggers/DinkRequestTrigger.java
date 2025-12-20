package com.streamerbot.triggers;
import com.google.gson.JsonSyntaxException;
import com.streamerbot.dinkdata.DinkCollectionNotificationData;
import com.streamerbot.dinkdata.DinkDeathNotificationData;
import com.streamerbot.dinkdata.DinkNotificationData;
import com.streamerbot.dinkdata.DinkNotificationType;
import com.streamerbot.messaging.DoActionRequest;
import net.runelite.client.events.PluginMessage;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Singleton;
import java.util.Map;

@Slf4j
@Singleton
public class DinkRequestTrigger extends BaseTrigger {

    private static final String DINK_KEY = "dinkplugin";

    private final Map<DinkNotificationType, Class<? extends DinkNotificationData>> registry = Map.of(
            DinkNotificationType.COLLECTION, DinkCollectionNotificationData.class,
            DinkNotificationType.DEATH, DinkDeathNotificationData.class
    );

    String actionNameFromConfig(DinkNotificationType type) {
        String key = type.name();
        return configManager.getConfiguration(CONFIG_GROUP, key, String.class);
    }

    private boolean collectionLogEnabled() {
        return config.collectionLogEnabled() && !config.collectionLogActionName().isEmpty();
    }

    private boolean deathEnabled() {
        return config.deathEnabled() && !config.deathActionName().isEmpty();
    }


     public void onPluginMessage(PluginMessage pluginMessage) {
        if (!pluginMessage.getNamespace().equals(DINK_KEY)) {
            log.debug("Not a Dink pluginMessage, returning");
            return;
        }

        DinkNotificationType type = DinkNotificationType.fromName(pluginMessage.getName());

        if(type == DinkNotificationType.DEATH) {
            if(!deathEnabled()) {
                log.debug("Death disabled, returning");
                return;
            }

            Map<String, Object> data = pluginMessage.getData();
            DinkNotificationData input;
            log.debug("Attempting to make request");
            Class<? extends DinkNotificationData> clazz = type.getDataClass();
            try {
                input = gson.fromJson(gson.toJsonTree(data), clazz);
            } catch (JsonSyntaxException e) {
                log.warn("Failed to parse Dink death notification: {}", data, e);
                return;
            }

            DoActionRequest request = new DoActionRequest(config.deathActionName(), input);
            String json = gson.toJson(request);
            log.debug(json);
            sendRequest(json);
        }
    }
}

