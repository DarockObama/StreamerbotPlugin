package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkGambleNotificationData extends DinkNotificationData {
    int gambleCount;
    List<Item> items;

    public DinkGambleNotificationData() {
        super(DinkNotificationType.BARBARIAN_ASSAULT_GAMBLE);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("gambleCount", gambleCount);
        map.put("items", gson.toJson(items));

        return map;
    }
}
