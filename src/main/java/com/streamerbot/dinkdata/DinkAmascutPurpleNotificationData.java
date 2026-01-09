package com.streamerbot.dinkdata;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.Collection;


@EqualsAndHashCode(callSuper = true)
@Data
public class DinkAmascutPurpleNotificationData extends DinkNotificationData {
    Collection<String> party;
    int reWardPoints;
    int raidLevel;
    double probability;

    public DinkAmascutPurpleNotificationData() {
        super(DinkNotificationType.TOA_UNIQUE);
    }
}
