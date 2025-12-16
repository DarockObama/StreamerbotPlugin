package com.streamerbot.messaging;
import com.streamerbot.fromdink.DinkDeathNotificationData;
import lombok.Getter;

@Getter
public class DeathRequest extends DoActionRequest {
    private final DinkDeathNotificationData args;

    public DeathRequest(String name, DinkDeathNotificationData args) {
        super(name);
        this.args = args;
    }
}
