package com.streamerbot;
import com.google.inject.Provides;
import javax.inject.Inject;

import com.streamerbot.triggers.DinkRequestTrigger;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.PluginMessage;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;


@Slf4j
@PluginDescriptor(
        name = "Streamerbot",
        description = "Lets in-game events trigger Streamerbot actions. <br/>"
                + "Requires the use of the Streamerbot application and Dink plugin",
        tags = {"streamer", "events", "trigger", "OBS", "Streamerbot", "Twitch"}
)

public class StreamerbotPlugin extends Plugin {
    @Inject
    private Client client;

    @Inject
    private StreamerbotConfig config;

    private @Inject DinkRequestTrigger dinkRequestTrigger;


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
    public void onPluginMessage(PluginMessage pluginMessage) {
        dinkRequestTrigger.onPluginMessage(pluginMessage);
    }


    @Provides
    StreamerbotConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(StreamerbotConfig.class);
    }
}
