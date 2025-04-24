
package com.example.mediatracker.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class Media implements Serializable{
    private static final long serialVersionUID = 1L;

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
