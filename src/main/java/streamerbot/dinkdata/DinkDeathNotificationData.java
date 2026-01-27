package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;


@EqualsAndHashCode(callSuper = true)
@Data
public class DinkDeathNotificationData extends DinkNotificationData {

    long valueLost = 0;
    boolean isPvp = false;
    String killerName = "N/A";
    int killerNpcId = 0;
    Collection<Item> keptItems = Collections.emptySet();
    Collection<Item> lostItems = Collections.emptySet();
    Region location;

    public DinkDeathNotificationData() {
        super(DinkNotificationType.DEATH);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("valueLost", valueLost);
        map.put("isPvp", isPvp);
        map.put("killerName", killerName);
        map.put("killerNpcId", killerNpcId);
        map.put("keptItems", gson.toJson(keptItems));
        map.put("lostItems", gson.toJson(lostItems));
        map.put("location", gson.toJson(location));

        return map;
    }
}