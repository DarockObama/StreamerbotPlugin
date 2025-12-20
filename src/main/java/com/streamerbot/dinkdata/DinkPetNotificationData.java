package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkPetNotificationData extends DinkNotificationData {
    String petName = "N/A";
    String milestone = "N/A";
    boolean duplicate;

    public DinkPetNotificationData() {
        super("PET");
    }
}
