package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkPetNotificationData extends DinkNotificationData {
    String petName = "N/A";
    String milestone = "N/A";
    boolean duplicate;
    boolean previouslyOwned = true; //defaults to true unless collection log notification happens in game
    Double rarity = 0.0;
    int estimatedActions = 0;
    Double luck = 0.0;


    public DinkPetNotificationData() {
        super(DinkNotificationType.PET);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("petName", petName);
        map.put("milestone", milestone);
        map.put("duplicate", duplicate);
        map.put("previouslyOwned", previouslyOwned);
        map.put("rarity", rarity);
        map.put("estimatedActions", estimatedActions);
        map.put("luck", luck);

        return map;
    }
}
