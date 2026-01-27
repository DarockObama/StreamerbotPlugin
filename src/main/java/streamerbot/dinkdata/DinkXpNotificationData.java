package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkXpNotificationData extends DinkNotificationData {
    Map<String, Integer> xpData;
    Collection<String> milestoneAchieved;
    int interval;

    public DinkXpNotificationData() {
        super(DinkNotificationType.XP_MILESTONE);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("xpData", gson.toJson(xpData));
        map.put("milestoneAchieved", gson.toJson((milestoneAchieved)));
        map.put("interval",interval);

        return map;
    }
}
