package com.streamerbot.dinkdata;
import lombok.Data;
import java.util.EnumSet;

//@Data
public class Loot extends Item {
    EnumSet<LootCriteria> criteria;
    Double rarity;

    public Loot() {
        this.criteria = EnumSet.noneOf(LootCriteria.class);
        this.rarity = 0.0;
    }
}
