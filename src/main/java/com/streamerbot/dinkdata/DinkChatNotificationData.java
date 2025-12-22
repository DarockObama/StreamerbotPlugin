package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.runelite.api.ChatMessageType;

//@EqualsAndHashCode(callSuper = false)
//@Data
public class DinkChatNotificationData extends DinkNotificationData {
    String type;
    String source;
    String clanTitle;
    String message;

    public DinkChatNotificationData() {
        super(DinkNotificationType.CHAT);
    }
}
