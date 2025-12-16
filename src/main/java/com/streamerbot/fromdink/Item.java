package com.streamerbot.fromdink;

public class Item {
    int id;
    int quantity;
    int priceEach;
    String name;

    Item(int id, int quantity, int priceEach, String name) {
        this.id = id;
        this.quantity = quantity;
        this.priceEach = priceEach;
        this.name = name;
    }
}
