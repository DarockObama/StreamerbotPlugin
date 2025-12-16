package com.streamerbot.fromdink;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkDeathNotificationData extends DinkNotificationData {

    private int valueLost;
    private boolean isPvp;
    private String killerName = "N/A";
    private int killerNpcId = 0;
    private Collection<Item> keptItems;
    private Collection<Item> lostItems;
    private Region location;

    public DinkDeathNotificationData() {
        super("DEATH");
    }
}
