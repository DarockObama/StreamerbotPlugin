package com.streamerbot.fromdink;
import lombok.Data;

@Data
public abstract class DinkNotificationData {

    protected String type;
    protected String playerName;
    protected String accountType;
    protected String plainText;
    protected DinkNotificationData() {
    }

    protected DinkNotificationData(String type) {
        this.type = type;
    }
}