package streamerbot.dinkdata;
import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;


import java.util.Collection;
import java.util.Map;


@EqualsAndHashCode(callSuper = true)
@Data
public class DinkAmascutPurpleNotificationData extends DinkNotificationData {
    Collection<String> party;
    int rewardPoints;
    int raidLevel;
    double probability;

    public DinkAmascutPurpleNotificationData() {
        super(DinkNotificationType.TOA_UNIQUE);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("party", gson.toJson(party));
        map.put("rewardPoints", rewardPoints);
        map.put("raidLevel", raidLevel);
        map.put("probability", probability);

        return map;
    }
}
