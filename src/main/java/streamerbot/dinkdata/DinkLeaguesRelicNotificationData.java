package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLeaguesRelicNotificationData extends DinkNotificationData {
    String relic;
    int tier;
    int requiredPoints;
    int totalPoints;
    int pointsUntilNextTier = 0;

    public DinkLeaguesRelicNotificationData() {
        super(DinkNotificationType.LEAGUES_RELIC);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("relic", relic);
        map.put("tier", tier);
        map.put("requiredPoints", requiredPoints);
        map.put("totalPoints", totalPoints);
        map.put("pointsUntilNextTier", pointsUntilNextTier);

        return map;
    }
}
