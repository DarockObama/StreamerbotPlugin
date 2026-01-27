package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkDiaryNotificationData extends DinkNotificationData {
    String area;
    String difficulty;
    int total;
    int tasksCompleted;
    int tasksTotal;
    int areaTasksCompleted;
    int areaTasksTotal;

    public DinkDiaryNotificationData() {
        super(DinkNotificationType.ACHIEVEMENT_DIARY);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("area", area);
        map.put("difficulty", difficulty);
        map.put("total", total);
        map.put("tasksCompleted", tasksCompleted);
        map.put("tasksTotal", tasksTotal);
        map.put("areaTasksCompleted", areaTasksCompleted);
        map.put("areaTasksTotal", areaTasksTotal);

        return map;
    }
}
