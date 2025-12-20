package com.streamerbot.dinkdata;
import lombok.Data;

@Data
public abstract class DinkNotificationData {

    String type;
    String playerName;
    String accountType;
    String plainText;

    DinkNotificationData() {}

    protected DinkNotificationData(String type) {
        this.type = type;
    }
}