package com.streamerbot.triggers;

import com.google.gson.JsonSyntaxException;
import com.streamerbot.fromdink.DinkDeathNotificationData;
import com.streamerbot.messaging.DeathRequest;
import com.streamerbot.messaging.DoActionRequest;
import net.runelite.client.events.PluginMessage;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Singleton
public class DinkRequestTrigger extends BaseTrigger {

    private static final String DINK_KEY = "dinkplugin";


    private boolean isEnabled() {
        return config.deathEnabled() && config.deathActionName() != null;
    }

    public void onPluginMessage(PluginMessage pluginMessage) {
        if(!isEnabled()) {
            log.debug("Death trigger disabled, returning");
        }

        if(!pluginMessage.getNamespace().equals(DINK_KEY)) {
            log.debug("Not a Dink pluginMessage, returning");
        }

        if(pluginMessage.getName().equals("DEATH")) {

            Map<String, Object> data  = pluginMessage.getData();
            log.debug("Attempting to make DoActionRequest");

            DinkDeathNotificationData input;

            try {
                input = gson.fromJson(gson.toJsonTree(data), DinkDeathNotificationData.class);
            } catch (JsonSyntaxException e) {
                log.warn("Failed to parse Dink daeth notification: {}", data, e);
                return;
            }


            DoActionRequest request = new DeathRequest(config.deathActionName(), input);
            String json = gson.toJson(request);
            log.debug(json);
            sendAction(json);


        }
    }
    private boolean shouldSend(String type) {
        return Objects.equals(type, "DEATH");
    }
}
