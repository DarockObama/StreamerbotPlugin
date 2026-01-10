package streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
}
