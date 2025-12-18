package com.streamerbot.messaging;
import com.streamerbot.fromdink.DinkCollectionNotificationData;
import lombok.Getter;

@Getter
public class CollectionLogRequest extends DoActionRequest {
    private final DinkCollectionNotificationData args;

    public CollectionLogRequest(String name, DinkCollectionNotificationData args) {
        super(name);
        this.args = args;
    }
}
