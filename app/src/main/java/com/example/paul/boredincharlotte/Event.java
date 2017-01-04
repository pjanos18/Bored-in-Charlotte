package com.example.paul.boredincharlotte;

/**
 * Created by Paul on 12/9/2016.
 */

public class Event {
    private String name;
    private String description;

    public Event (String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
