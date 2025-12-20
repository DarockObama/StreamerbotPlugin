package com.streamerbot.triggers;

import com.google.gson.Gson;
import com.streamerbot.StreamerbotConfig;
import com.streamerbot.messaging.TriggerHandler;
import com.streamerbot.util.HttpUrlAdapter;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;
import okhttp3.HttpUrl;

@Slf4j
public abstract class BaseTrigger {
    protected Gson gson;

    @Inject
    void init(Gson gson) {
        this.gson = gson.newBuilder()
                .registerTypeAdapter(HttpUrl.class, new HttpUrlAdapter())
                .create();
    }

    @Inject
    protected ConfigManager configManager;

    @Inject
    protected StreamerbotConfig config;

    @Inject
    protected Client client;

    @Inject
    private TriggerHandler triggerHandler;

    protected static final String CONFIG_GROUP = "StreamerbotPlugin";

    protected void sendRequest(String json) {
        triggerHandler.sendJson(json);
    }
}
