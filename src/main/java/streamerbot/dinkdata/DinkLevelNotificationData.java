package streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLevelNotificationData extends DinkNotificationData {
    Map<String, Integer> levelledSkills;
    Map<String, Integer> allSkills;
    CombatLevel combatLevel;

    public DinkLevelNotificationData() {
        super(DinkNotificationType.LEVEL);
    }

    @Data
    public static class CombatLevel {
        int value;
        boolean increased;
    }
}
