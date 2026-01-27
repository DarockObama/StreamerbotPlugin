package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.EqualsAndHashCode;
import lombok.Data;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkCombatAchievementNotificationData extends DinkNotificationData {
    String tier;
    String task;
    int taskPoints;
    int totalPoints;
    int tierProgress = 0;
    int tierTotalPoints = 0;
    int totalPossiblePoints;
    String currentTier = "N/A";
    String nextTier = "N/A";
    String justCompletedTier = "N/A";

    public DinkCombatAchievementNotificationData() {
        super(DinkNotificationType.COMBAT_ACHIEVEMENT);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("tier", tier);
        map.put("task", task);
        map.put("taskPoints", taskPoints);
        map.put("totalPoints", totalPoints);
        map.put("tierProgress", tierProgress);
        map.put("tierTotalPoints", tierTotalPoints);
        map.put("totalPossiblePoints", totalPossiblePoints);
        map.put("currentTier", currentTier);
        map.put("nextTier", nextTier);
        map.put("justCompletedTier", justCompletedTier);

        return map;
    }
}
