package streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkGroupStorageNotificationData extends DinkNotificationData {
    Collection<Item> deposits;
    Collection<Item> withdrawals;
    long netValue;
    String groupName;
    boolean includePrice;

    public DinkGroupStorageNotificationData() {
        super(DinkNotificationType.GROUP_STORAGE);
    }
}
