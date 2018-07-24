package com.example.sjonqui.ecowidget;

/**
 * Created by sjonqui on 24/07/18.
 */

public class NewsItem {
    private String itemName;
    private String itemDescription;

    public NewsItem(String name, String description) {
        this.itemName = name;
        this.itemDescription = description;
    }

    public String getItemName() {
        return this.itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}
