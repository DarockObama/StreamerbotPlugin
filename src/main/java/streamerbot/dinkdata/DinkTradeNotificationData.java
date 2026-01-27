package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkTradeNotificationData extends DinkNotificationData {
    String counterparty;
    List<Item> receivedItems;
    List<Item> givenItems;
    long receivedValue;
    long givenValue;

    public DinkTradeNotificationData() {
        super(DinkNotificationType.TRADE);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("counterparty", counterparty);
        map.put("receivedItems", gson.toJson(receivedItems));
        map.put("givenItems", gson.toJson(givenItems));
        map.put("receivedValue", receivedValue);
        map.put("givenValue", givenValue);

        return map;
    }
}
