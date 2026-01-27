package streamerbot.dinkdata;

import com.google.gson.Gson;
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

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("levelledSkills", gson.toJson(levelledSkills));
        map.put("allSkills", gson.toJson(allSkills));
        map.put("combatLevel", gson.toJson(combatLevel));
        
        return map;
    }
}
