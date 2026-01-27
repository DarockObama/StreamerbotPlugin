package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.EqualsAndHashCode;
import lombok.Data;
import net.runelite.api.GrandExchangeOfferState;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkGrandExchangeNotificationData extends DinkNotificationData {
    int slot;
    GrandExchangeOfferState status;
    Item item;
    long marketPrice;
    long targetPrice;
    int targetQuantity;
    long sellerTax = 0;

    public DinkGrandExchangeNotificationData() {
        super(DinkNotificationType.GRAND_EXCHANGE);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("slot", slot);
        map.put("status", gson.toJson(status));
        map.put("item", gson.toJson(item));
        map.put("marketPrice", marketPrice);
        map.put("targetPrice", targetPrice);
        map.put("targetQuantity", targetQuantity);
        map.put("sellerTax", sellerTax);

        return map;
    }
}
