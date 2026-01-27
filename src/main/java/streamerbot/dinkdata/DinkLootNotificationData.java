package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLootNotificationData extends DinkNotificationData {
    Collection<Loot> items;
    String source;
    Collection<String> party = Collections.emptySet();
    String category;
    int killCount = 0;
    Double rarestProbability = 0.0;
    int npcId = 0;

    public DinkLootNotificationData() {
        super(DinkNotificationType.LOOT);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("items", gson.toJson(items));
        map.put("source", source);
        map.put("party", gson.toJson(party));
        map.put("category", category);
        map.put("killCount", killCount);
        map.put("rarestProbability", rarestProbability);
        map.put("npcId", npcId);

        return map;
    }
}