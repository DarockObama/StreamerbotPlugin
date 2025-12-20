package com.streamerbot.dinkdata;
import lombok.Data;
import java.util.EnumSet;

@Data
public class Loot extends Item {
    EnumSet<LootCriteria> criteria = EnumSet.noneOf(LootCriteria.class);
    Double rarity = 0.0;
}
