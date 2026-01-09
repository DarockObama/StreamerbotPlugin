package com.streamerbot.dinkdata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.EnumSet;
@EqualsAndHashCode(callSuper = true)
@Data
public class Loot extends Item {
    EnumSet<LootCriteria> criteria;
    Double rarity;

    public Loot() {
        this.criteria = EnumSet.noneOf(LootCriteria.class);
        this.rarity = 0.0;
    }
}
