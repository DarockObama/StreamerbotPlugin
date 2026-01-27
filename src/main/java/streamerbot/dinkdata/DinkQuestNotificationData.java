package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkQuestNotificationData extends DinkNotificationData {
    String questName;
    int completedQuests = 0;
    int totalQuests = 0;
    int questPoints = 0;
    int totalQuestPoints = 0;

    DinkQuestNotificationData () {
        super(DinkNotificationType.QUEST);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("questName", questName);
        map.put("completedQuests", completedQuests);
        map.put("totalQuests", totalQuests);
        map.put("questPoints", questPoints);
        map.put("totalQuestPoints", totalQuestPoints);

        return map;
    }
}
