package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkExternalNotificationData extends DinkNotificationData {
    String sourcePlugin;
    Map<String, Object> metadata = Collections.emptyMap();

    public DinkExternalNotificationData() {
        super(DinkNotificationType.EXTERNAL_PLUGIN);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("sourcePlugin", sourcePlugin);
        map.put("metadata", gson.toJson(metadata));

        return map;
    }
}
