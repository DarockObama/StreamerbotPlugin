package com.streamerbot.dinkdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class DinkTradeNotificationData extends DinkNotificationData {
    String counterparty;
    List<Item> receivedItems;
    List<Item> givenItems;
    long receivedValue;
    long givenValue;

    public DinkTradeNotificationData() {
        super(DinkNotificationType.TRADE);
    }
}
