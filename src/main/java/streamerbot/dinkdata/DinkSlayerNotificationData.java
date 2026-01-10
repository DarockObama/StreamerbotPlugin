package streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkSlayerNotificationData extends DinkNotificationData {
    String slayerTask;
    int slayerCompleted = 0;
    int slayerPoints = 0;
    int killCount = 0;
    String monster = "N/A";

    public DinkSlayerNotificationData() {
        super(DinkNotificationType.SLAYER);
    }
}
