package com.evcheung.apps.segmentation.controllers;

import java.util.ArrayList;

public class SegmentationResponse {
    String text;

    public ArrayList<String> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<String> segments) {
        this.segments = segments;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    ArrayList<String> segments;
}
