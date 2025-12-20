package com.streamerbot.dinkdata;

import lombok.Data;

@Data
public class Item {
    int id;
    int quantity;
    int priceEach;
    String name;
}
