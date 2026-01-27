package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkChatNotificationData extends DinkNotificationData {
    String type;
    String source = "N/A";
    String clanTitle = "N/A";
    String message;

    public DinkChatNotificationData() {
        super(DinkNotificationType.CHAT);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("type", type);
        map.put("source", source);
        map.put("clanTitle", clanTitle);
        map.put("message", message);

        return map;
    }
}
