package streamerbot.dinkdata;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.EnumSet;

@EqualsAndHashCode(callSuper = true)
@Data
public class AnnotatedItem extends Item {
    EnumSet<LootCriteria> criteria;
    Double rarity;

    public AnnotatedItem() {
        this.criteria = EnumSet.noneOf(LootCriteria.class);
        this.rarity = 0.0;
    }
}
