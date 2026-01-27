package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkGroupStorageNotificationData extends DinkNotificationData {
    Collection<Item> deposits;
    Collection<Item> withdrawals;
    long netValue;
    String groupName;

    public DinkGroupStorageNotificationData() {
        super(DinkNotificationType.GROUP_STORAGE);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("deposits", gson.toJson(deposits));
        map.put("withdrawals", gson.toJson(withdrawals));
        map.put("netValue", netValue);
        map.put("groupName", groupName);

        return map;
    }
}
