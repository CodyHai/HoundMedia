
package com.example.mediatracker.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import java.util.ArrayList;

public class Day implements Serializable{

    private static final long serialVersionUID = 1L;
    private ArrayList<Media> mediaList;

    public Day() {
        mediaList = new ArrayList<>();
    }

    public void addMedia(Media media) {
        mediaList.add(media);
    }

    public ArrayList<Media> getMediaList() {
        return mediaList;
    }
}
