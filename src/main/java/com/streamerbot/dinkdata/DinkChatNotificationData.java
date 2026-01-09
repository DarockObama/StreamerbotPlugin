package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkChatNotificationData extends DinkNotificationData {
    String type;
    String source;
    String clanTitle;
    String message;

    public DinkChatNotificationData() {
        super(DinkNotificationType.CHAT);
    }
}
