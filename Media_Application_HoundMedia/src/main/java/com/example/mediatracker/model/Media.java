
package com.example.mediatracker.model;

public class Media {
    private String name;
    private String tag;
    private double length;

    public Media(String name, String tag, double length) {
        this.name = name;
        this.tag = tag;
        this.length = length;
    }

    public String getName() { return name; }
    public String getTag() { return tag; }
    public double getLength() { return length; }
}
