package com.streamerbot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import okhttp3.*;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TriggerHandler {
    @Inject
    StreamerbotConfig config;

    private final  OkHttpClient okHttpClient = new OkHttpClient();

    private static final Logger log = LoggerFactory.getLogger(TriggerHandler.class);

    private String getAddress() {
        return "http://" + config.streamerbotAddress() + ":" + config.streamerbotPort();
    }

    public void sendJson(String payload) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), payload);
        Request request = new Request.Builder()
                .url(getAddress() + "/DoAction")
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
