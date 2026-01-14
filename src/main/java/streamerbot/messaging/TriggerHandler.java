package streamerbot.messaging;
import streamerbot.StreamerbotConfig;
import org.apache.commons.lang3.StringUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class TriggerHandler {
    @Inject
    StreamerbotConfig config;

    @Inject
    private OkHttpClient okHttpClient;

    public void sendJson(String payload) {
        if(StringUtils.isBlank(config.streamerbotAddress())) {
            log.error("No address provided");
        }

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), payload);
        Request request = new Request.Builder()
                .url(config.streamerbotAddress() + "/DoAction")
                .post(body)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("POST request failed. Response Code: {}", response.code());
            } else {
                log.info("POST request succeeded!");
            }
        } catch (Exception e) {
            log.error("Error during POST request", e);
        }
    }
}
