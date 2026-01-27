package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkSlayerNotificationData extends DinkNotificationData {
    String slayerTask;
    int slayerCompleted;
    int slayerPoints;
    int killCount = 0;
    String monster = "N/A";

    public DinkSlayerNotificationData() {
        super(DinkNotificationType.SLAYER);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("slayerTask", slayerTask);
        map.put("slayerCompleted", slayerCompleted);
        map.put("slayerPoints", slayerPoints);
        map.put("killCount", killCount);
        map.put("monster", monster);

        return map;
    }
}
