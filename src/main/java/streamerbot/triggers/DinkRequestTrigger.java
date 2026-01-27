package streamerbot.triggers;

import com.google.gson.JsonSyntaxException;
import streamerbot.SettingsManager;
import streamerbot.dinkdata.*;
import streamerbot.dinkdata.DinkNotificationData;
import streamerbot.dinkdata.DinkNotificationType;
import streamerbot.messaging.DoActionRequest;
import net.runelite.client.events.PluginMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import javax.inject.Singleton;
import java.util.Map;

@Slf4j
@Singleton
public class DinkRequestTrigger extends BaseTrigger {

    private static final String DINK_KEY = "dinkplugin";

    public void onPluginMessage(PluginMessage pluginMessage)  {
        if (!pluginMessage.getNamespace().equals(DINK_KEY)) {
            return;
        }

        DinkNotificationType notificationType = DinkNotificationType.fromName(pluginMessage.getName());

        if (notificationType == DinkNotificationType.UNKNOWN) {
            return;
        }

        boolean enabled = configManager.getConfiguration(SettingsManager.CONFIG_GROUP, notificationType.getEnabledKey(), boolean.class);
        String actionName = configManager.getConfiguration(SettingsManager.CONFIG_GROUP, notificationType.getActionKey(), String.class);

        if (!enabled ||  StringUtils.isBlank(actionName)) {
            log.debug("Notification type {} is disabled, returning", notificationType.getType());
            return;
        }

        Map<String, Object> data = pluginMessage.getData();

        Class<? extends DinkNotificationData> clazz = notificationType.getDataClass();
        DinkNotificationData input;

        try {
            input = gson.fromJson(gson.toJsonTree(data), clazz);
        } catch (JsonSyntaxException e) {
            log.warn("Failed to parse Dink death notification: {}", data, e);
            return;
        }

        Map<String, Object> args = input.sanitized(gson);
        DoActionRequest request = new DoActionRequest(actionName,  args);
        String json = gson.toJson(request);
        sendRequest(json);
    }
}

