package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkClueNotificationData extends DinkNotificationData {
    String clueType;
    int numberCompleted;
    Collection<Item> items;

    public DinkClueNotificationData() {
        super(DinkNotificationType.CLUE);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("clueType", clueType);
        map.put("numberCompleted", numberCompleted);
        map.put("items", gson.toJson(items));

        return map;
    }
}
