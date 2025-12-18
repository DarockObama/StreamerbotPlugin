package com.streamerbot.triggers;

import com.google.gson.JsonSyntaxException;
import com.streamerbot.fromdink.DinkCollectionNotificationData;
import com.streamerbot.fromdink.DinkDeathNotificationData;
import com.streamerbot.fromdink.DinkNotificationType;
import com.streamerbot.messaging.CollectionLogRequest;
import com.streamerbot.messaging.DeathRequest;
import net.runelite.client.events.PluginMessage;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.Map;

@Slf4j
@Singleton
public class DinkRequestTrigger extends BaseTrigger {

    private static final String DINK_KEY = "dinkplugin";

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

        switch(type) {
            case DEATH:
                if(!deathEnabled()) {
                    log.debug("Death trigger disabled, returning");
                    return;
                }

                createDeathRequest(pluginMessage);
                break;

            case COLLECTION:
                if(!collectionLogEnabled()) {
                    log.debug("Collection trigger disabled, returning");
                    return;
                }

                createCollectionRequest(pluginMessage);
                break;
        }
    }

    private void createDeathRequest(PluginMessage pluginMessage) {
        Map<String, Object> data = pluginMessage.getData();
        DinkDeathNotificationData input;

        log.debug("Attempting to make DoActionRequest");
        try {
            input = gson.fromJson(gson.toJsonTree(data), DinkDeathNotificationData.class);
        } catch (JsonSyntaxException e) {
            log.warn("Failed to parse Dink death notification: {}", data, e);
            return;
        }

        DeathRequest request = new DeathRequest(config.deathActionName(), input);
        String json = gson.toJson(request);
        log.debug(json);
        sendRequest(json);
    }

    private void createCollectionRequest(PluginMessage pluginMessage) {
        Map<String, Object> data = pluginMessage.getData();
        DinkCollectionNotificationData input;

        log.debug("Attempting to make CollectionLogRequest");
        try {
            input = gson.fromJson(gson.toJsonTree(data), DinkCollectionNotificationData.class);
        } catch (JsonSyntaxException e) {
            log.warn("Failed to parse Dink collection log notification: {}", data, e);
            return;
        }

        CollectionLogRequest request = new CollectionLogRequest(config.deathActionName(), input);
        String json = gson.toJson(request);
        log.debug(json);
        sendRequest(json);
    }
}

