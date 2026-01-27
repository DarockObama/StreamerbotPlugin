package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLeaguesTaskNotificationData extends DinkNotificationData {
    String taskName;
    String difficulty;
    int taskPoints;
    int totalPoints;
    int tasksCompleted;

    int tasksUntilNextArea = 0;
    int pointsUntilNextRelic = 0;
    int pointsUntilNextTrophy = 0;
    String earnedTrophy = "N/A";

    public DinkLeaguesTaskNotificationData() {
        super(DinkNotificationType.LEAGUES_TASK);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("taskName", taskName);
        map.put("difficulty", difficulty);
        map.put("taskPoints", taskPoints);
        map.put("totalPoints", totalPoints);
        map.put("tasksCompleted", tasksCompleted);
        map.put("tasksUntilNextArea", tasksUntilNextArea);
        map.put("pointsUntilNextRelic", pointsUntilNextRelic);
        map.put("pointsUntilNextTrophy", pointsUntilNextTrophy);
        map.put("earnedTrophy", earnedTrophy);

        return map;
    }
}
