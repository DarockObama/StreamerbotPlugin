package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;


@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@Data
public class DinkSpeedrunNotificationData extends DinkNotificationData {
    String questName;
    String personalBest;
    String currentTime;
    boolean isPersonalBest;

    public DinkSpeedrunNotificationData() {
        super(DinkNotificationType.SPEEDRUN);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("questName", questName);
        map.put("personalBest", personalBest);
        map.put("currentTime", currentTime);
        map.put("isPersonalBest", isPersonalBest);

        return map;
    }
}
