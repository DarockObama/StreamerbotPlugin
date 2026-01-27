package streamerbot.dinkdata;
import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkNotificationData extends NotificationData {
    DinkNotificationType notificationType;
    String playerName;
    String accountType;
    String plainText;

    public DinkNotificationData() {
    }

    protected DinkNotificationData(DinkNotificationType notificationType) {
        this.notificationType = notificationType;
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = new HashMap<>();
        map.put("notificationType", notificationType);
        map.put("playerName", playerName);
        map.put("accountType", accountType);
        map.put("plainText", plainText);
        return map;
    }
}