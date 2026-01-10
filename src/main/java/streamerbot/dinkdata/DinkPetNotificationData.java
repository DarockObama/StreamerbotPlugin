package streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
}
