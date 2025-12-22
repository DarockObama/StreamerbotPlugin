package com.streamerbot.dinkdata;
import lombok.Data;
import lombok.EqualsAndHashCode;

//@EqualsAndHashCode(callSuper = false)
//Data
public abstract class DinkNotificationData {

    DinkNotificationType notificationType;
    String playerName;
    String accountType;
    String plainText;

    DinkNotificationData() {}

    protected DinkNotificationData(DinkNotificationType notificationType) {
        this.notificationType = notificationType;
    }
}