package com.streamerbot.messaging;
import com.streamerbot.StreamerbotConfig;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import javax.inject.Inject;
import javax.inject.Singleton;

@Slf4j
@Singleton
public class TriggerHandler {
    @Inject
    StreamerbotConfig config;

    private final  OkHttpClient okHttpClient = new OkHttpClient();


    public void sendJson(String payload) {
        if(config.streamerbotAddress().isBlank()) {
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
