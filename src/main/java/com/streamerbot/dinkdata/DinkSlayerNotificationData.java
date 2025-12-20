package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkSlayerNotificationData extends DinkNotificationData {
    String slayerTask;
    String slayerCompleted;
    String slayerPoints;


}
