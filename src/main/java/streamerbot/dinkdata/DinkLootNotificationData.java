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
    Collection<AnnotatedItem> items;
    String source;
    String category;
    int killCount = 0;
    Double rarestProbability = 0.0;
    Collection<String> party = Collections.emptySet();
    int npcId = 0;

    public DinkLootNotificationData() {
        super(DinkNotificationType.LOOT);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("items", gson.toJson(items));
        map.put("source", source);
        map.put("category", category);
        map.put("killCount", killCount);
        map.put("rarestProbability", rarestProbability);
        map.put("party", gson.toJson(party));
        map.put("npcId", npcId);

        return map;
    }
}