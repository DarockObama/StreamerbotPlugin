package streamerbot.dinkdata;

import com.google.gson.Gson;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkCollectionNotificationData extends DinkNotificationData {
    String itemName = "N/A";
    int itemId = 0;
    long price = 0;
    int completedEntries = 0;
    int totalEntries = 0;
    String currentRank = "N/A";
    int rankProgress = 0;
    int logsNeededForNextRank = 0;
    String nextRank = "N/A";
    String justCompletedRank = "N/A";
    String dropperName = "N/A";
    String dropperType = "N/A";
    int dropperKillCount = 0;
    Double dropRate = 0.0;

    public DinkCollectionNotificationData() {
        super(DinkNotificationType.COLLECTION);
    }

    @Override
    public Map<String, Object> sanitized(Gson gson) {
        Map<String, Object> map = super.sanitized(gson);

        map.put("itemName", itemName);
        map.put("itemId", itemId);
        map.put("price", price);
        map.put("completedEntries", completedEntries);
        map.put("totalEntries", totalEntries);
        map.put("currentRank", currentRank);
        map.put("rankProgress", rankProgress);
        map.put("logsNeededForNextRank", logsNeededForNextRank);
        map.put("nextRank", nextRank);
        map.put("justCompletedRank", justCompletedRank);
        map.put("dropperName", dropperName);
        map.put("dropperType", dropperType);
        map.put("dropperKillCount", dropperKillCount);
        map.put("dropRate", dropRate);

        return map;
    }
}