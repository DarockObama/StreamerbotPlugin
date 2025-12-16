package com.streamerbot.fromdink;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Collection;

import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkDeathNotificationData extends DinkNotificationData {

    private long valueLost;
    private boolean isPvp;
    private String killerName = "N/A";
    private int killerNpcId = 0;
    private Collection<Map<String, Object>> keptItems;
    private Collection<Map<String, Object>> lostItems;
    private Map<String, Object> location;

    public DinkDeathNotificationData() {
        super("DEATH");
    }
}
