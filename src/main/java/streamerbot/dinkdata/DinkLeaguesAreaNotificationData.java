package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLeaguesAreaNotificationData extends DinkNotificationData {
    String area;
    int index;
    int tasksCompleted;
    int tasksUntilNextArea = 0;

    public DinkLeaguesAreaNotificationData() {
        super(DinkNotificationType.LEAGUES_AREA);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("area", area);
        map.put("index", index);
        map.put("tasksCompleted", tasksCompleted);
        map.put("tasksUntilNextArea", tasksUntilNextArea);

        return map;
    }
}
