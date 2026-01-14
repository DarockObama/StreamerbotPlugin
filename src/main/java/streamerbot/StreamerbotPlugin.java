package streamerbot;
import com.google.inject.Provides;
import javax.inject.Inject;

import streamerbot.triggers.DinkRequestTrigger;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.client.chat.ChatMessageManager;
import net.runelite.client.chat.QueuedMessage;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.events.PluginMessage;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.ColorUtil;

import java.awt.*;


@Slf4j
@PluginDescriptor(
        name = "Streamerbot",
        description = "Lets in-game events trigger Streamerbot actions. <br/>"
                + "Requires the use of the Streamerbot application and Dink plugin",
        tags = {"streamer", "notifier", "trigger", "OBS", "Streamerbot", "Twitch"}
)

public class StreamerbotPlugin extends Plugin {
    @Inject
    private ChatMessageManager chatManager;

    @Inject
    private Client client;

    @Inject
    private StreamerbotConfig config;

    @Inject
    private DinkRequestTrigger dinkRequestTrigger;

    @Inject
    private SettingsManager settingsManager;

    @Override
    protected void startUp() {
        log.info("Streamerbot started!");
    }

    @Override
    protected void shutDown()
    {
        log.info("Streamerbot stopped!");
    }

    @Subscribe
    public void onConfigChanged(ConfigChanged configChanged) {
        if(!configChanged.getGroup().equals(SettingsManager.CONFIG_GROUP)) {
            return;
        }

        settingsManager.onConfigChanged(configChanged);
    }

    @Subscribe
    public void onPluginMessage(PluginMessage pluginMessage) {
        dinkRequestTrigger.onPluginMessage(pluginMessage);
    }

    private final static Color CYAN = ColorUtil.fromHex("#00c7ff");
    private final static Color RED = ColorUtil.fromHex("#ca2a2d");


    public void queueMessage(String formatted) {
        chatManager.queue(
        QueuedMessage.builder()
                .type(ChatMessageType.CONSOLE)
                .runeLiteFormattedMessage(formatted)
                .build()
        );
    }

    public void addChatWarning(String message) {
        String formatted = String.format("[%s] %s: %s",
                ColorUtil.wrapWithColorTag(getName(), CYAN),
                "Warning",
                ColorUtil.wrapWithColorTag(message, RED)
        );

        queueMessage(formatted);
    }

    public void addChatNotice(String message) {
        String formatted = String.format("[%s] %s: %s",
                ColorUtil.wrapWithColorTag(getName(), CYAN),
                "Notice",
                message
        );

        queueMessage(formatted);
    }

    @Provides
    StreamerbotConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(StreamerbotConfig.class);
    }
}
