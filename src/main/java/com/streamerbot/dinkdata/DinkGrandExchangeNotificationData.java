package com.streamerbot.dinkdata;

import lombok.EqualsAndHashCode;
import lombok.Data;
import net.runelite.api.GrandExchangeOfferState;

//@EqualsAndHashCode(callSuper = false)
//@Data
public class DinkGrandExchangeNotificationData extends DinkNotificationData {
    int slot;
    GrandExchangeOfferState status;
    Item item;
    long marketPrice;
    long targetPrice;
    int targetQuantity;
    long sellerTax = 0;

    public DinkGrandExchangeNotificationData() {
        super(DinkNotificationType.GRAND_EXCHANGE);
    }
}
