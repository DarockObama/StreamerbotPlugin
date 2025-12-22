package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

//@EqualsAndHashCode(callSuper = false)
//@Data
public class DinkExternalNotificationData extends DinkNotificationData {
    String sourcePlugin;
    Map<String, Object> metadata;

    public DinkExternalNotificationData() {
        super(DinkNotificationType.EXTERNAL_PLUGIN);
    }
}
