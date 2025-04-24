
package com.example.mediatracker.model;

import java.util.ArrayList;

public class Day {
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
