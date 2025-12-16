package com.streamerbot.triggers;

import com.google.gson.JsonSyntaxException;
import com.streamerbot.fromdink.DinkDeathNotificationData;
import com.streamerbot.fromdink.DinkNotificationType;
import com.streamerbot.messaging.DeathRequest;
import net.runelite.client.events.PluginMessage;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Singleton
public class DinkRequestTrigger extends BaseTrigger {

    private static final String DINK_KEY = "dinkplugin";


    private boolean deathEnabled() {
        return config.deathEnabled() && !config.deathActionName().isEmpty();
    }

    public void onPluginMessage(PluginMessage pluginMessage) {


        if(!pluginMessage.getNamespace().equals(DINK_KEY)) {
            log.debug("Not a Dink pluginMessage, returning");
            return;
        }

        if(DinkNotificationType.fromName(pluginMessage.getName()) == DinkNotificationType.DEATH) {
            if(!deathEnabled()) {
                log.debug("Death trigger disabled, returning");
                return;
            }

            Map<String, Object> data  = pluginMessage.getData();
            log.debug("Attempting to make DoActionRequest");

            DinkDeathNotificationData input;

            try {
                input = gson.fromJson(gson.toJsonTree(data), DinkDeathNotificationData.class);
            } catch (JsonSyntaxException e) {
                log.warn("Failed to parse Dink death notification: {}", data, e);
                return;
            }


            DeathRequest request = new DeathRequest(config.deathActionName(), input);
            String json = gson.toJson(request);
            log.debug(json);
            sendAction(json);


        }
    }


      /*  if(pluginMessage.getName().equals("DEATH")) {

            Map<String, Object> data  = pluginMessage.getData();
            log.debug("Attempting to make DoActionRequest");

            DinkDeathNotificationData input;

            try {
                input = gson.fromJson(gson.toJsonTree(data), DinkDeathNotificationData.class);
            } catch (JsonSyntaxException e) {
                log.warn("Failed to parse Dink daeth notification: {}", data, e);
                return;
            }

            DeathRequest request = new DeathRequest(config.deathActionName(), input);
            String json = gson.toJson(request);
            log.debug(json);
            sendAction(json);
        }
    }*/
    private boolean shouldSend(String type) {
        return Objects.equals(type, "DEATH");
    }
}
