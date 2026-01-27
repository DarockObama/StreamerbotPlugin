package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.kit.KitType;

import java.util.Map;


@EqualsAndHashCode(callSuper = true)
@Data
public class DinkPlayerKillNotificationData extends DinkNotificationData {
    String victimName;
    int victimCombatLevel;
    Map<KitType, Item> victimEquipment;
    int world = 0;
    WorldPoint location = new WorldPoint(-1, -1, -1);
    int myHitpoints;
    int myLastDamage;

    DinkPlayerKillNotificationData() {
        super(DinkNotificationType.PLAYER_KILL);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("victimName", victimName);
        map.put("victimCombatLevel", victimCombatLevel);
        map.put("victimEquipment", gson.toJson(victimEquipment));
        map.put("world", world);
        map.put("location", gson.toJson(location));
        map.put("myHitpoints", myHitpoints);
        map.put("myLastDamage", myLastDamage);

        return map;
    }
}
