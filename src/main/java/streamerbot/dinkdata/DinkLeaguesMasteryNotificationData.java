package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkLeaguesMasteryNotificationData extends DinkNotificationData {
    String masteryType;
    int masteryTier;

    public DinkLeaguesMasteryNotificationData() {
        super(DinkNotificationType.LEAGUES_MASTERY);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("masteryType", masteryType);
        map.put("masteryTier", masteryTier);

        return map;
    }
}
