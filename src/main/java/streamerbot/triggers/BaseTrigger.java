package streamerbot.triggers;


import com.google.gson.Gson;
import streamerbot.StreamerbotConfig;
import streamerbot.messaging.TriggerHandler;
import streamerbot.util.StringToIntAdapter;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.config.ConfigManager;

@Slf4j
public abstract class BaseTrigger {
    protected Gson gson;

    @Inject
    void init(Gson gson) {
        this.gson = gson.newBuilder()
                .registerTypeAdapter(Integer.class, new StringToIntAdapter())
                .registerTypeAdapter(int.class, new StringToIntAdapter())
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

    protected void sendRequest(String json) {
        triggerHandler.sendJson(json);
    }
}
