package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
        super("COLLECTION");
    }
}