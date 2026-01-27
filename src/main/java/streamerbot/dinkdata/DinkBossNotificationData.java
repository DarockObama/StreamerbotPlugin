package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkBossNotificationData extends DinkNotificationData {
    String boss;
    int count;
    String gameMessage;
    String time;
    Boolean isPersonalBest;
    String personalBest;
    Collection<String> party = Collections.emptySet();

    public DinkBossNotificationData() {
        super(DinkNotificationType.KILL_COUNT);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("boss", boss);
        map.put("count", count);
        map.put("gameMessage", gameMessage);
        map.put("time", time);
        map.put("isPersonalBest", isPersonalBest);
        map.put("personalBest", personalBest);
        map.put("party", gson.toJson(party));

        return map;
    }
}


