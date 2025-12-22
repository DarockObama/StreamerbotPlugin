package com.streamerbot.triggers;
import com.google.gson.JsonSyntaxException;
import com.streamerbot.ConfigKeys;
import com.streamerbot.dinkdata.*;
import com.streamerbot.messaging.DoActionRequest;
import net.runelite.client.events.PluginMessage;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Singleton;
import java.util.Map;

@Slf4j
@Singleton
public class DinkRequestTrigger extends BaseTrigger {

    private static final String DINK_KEY = "dinkplugin";

    String actionName(DinkNotificationType type) {
        return configManager.getConfiguration(CONFIG_GROUP, type.getActionKey(), String.class);
    }

     public void onPluginMessage(PluginMessage pluginMessage) {
        if (!pluginMessage.getNamespace().equals(DINK_KEY)) {
            log.debug("Not a Dink pluginMessage, returning");
            return;
        }

        DinkNotificationType notificationType = DinkNotificationType.fromName(pluginMessage.getName());

        if(notificationType == DinkNotificationType.UNKNOWN) {
            log.debug("Invalid notification, returning");
            return;
        }

        boolean enabled = configManager.getConfiguration(ConfigKeys.CONFIG_GROUP, notificationType.getEnabledKey(), boolean.class);
        String actionName = configManager.getConfiguration(ConfigKeys.CONFIG_GROUP, notificationType.getActionKey(), String.class);

        if(!enabled || actionName.isEmpty()) {
            log.debug("Notification type {} is disabled, returning", notificationType.getType());
            return;
        }


        Map<String, Object> data = pluginMessage.getData();
        DinkNotificationData input;
            log.debug("Attempting to make request");
            Class<? extends DinkNotificationData> clazz = notificationType.getDataClass();
            try {
                input = gson.fromJson(gson.toJsonTree(data), clazz);
            } catch (JsonSyntaxException e) {
                log.warn("Failed to parse Dink death notification: {}", data, e);
                return;
            }

            DoActionRequest request = new DoActionRequest(actionName, input);
            String json = gson.toJson(request);
            log.debug(json);
            sendRequest(json);
    }

}

