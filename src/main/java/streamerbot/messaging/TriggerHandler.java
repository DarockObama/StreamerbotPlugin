package streamerbot.messaging;
import streamerbot.StreamerbotConfig;
import org.apache.commons.lang3.StringUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import javax.annotation.Nonnull;
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
        if (StringUtils.isBlank(config.streamerbotAddress())) {
            log.error("No address provided");
            return; // important: don't continue
        }

        RequestBody body = RequestBody.create(
                MediaType.parse("application/json"),
                payload
        );

        Request request = new Request.Builder()
                .url(config.streamerbotAddress() + "/DoAction")
                .post(body)
                .build();

        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@Nonnull okhttp3.Call call,@Nonnull  java.io.IOException e) {
                log.error("Error during POST request", e);
            }

            @Override
            public void onResponse(@Nonnull okhttp3.Call call, @Nonnull okhttp3.Response response) {
                try (okhttp3.Response res = response) {
                    if (!res.isSuccessful()) {
                        log.error("POST request failed. Response Code: {}", res.code());
                    } else {
                        log.info("POST request succeeded!");
                    }
                }
            }
        });
    }
}
