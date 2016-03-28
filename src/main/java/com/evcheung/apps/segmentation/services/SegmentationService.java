package com.evcheung.apps.segmentation.services;

import com.chenlb.mmseg4j.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

@Component
public class SegmentationService {
    private final ComplexSeg seg;

    public SegmentationService() {
        Dictionary dic = Dictionary.getInstance();
        seg = new ComplexSeg(dic);
    }

    public ArrayList<String> mmseg(String text) throws IOException {
        MMSeg mmSeg = new MMSeg(new StringReader(text), seg);

        ArrayList<String> segmentation = new ArrayList<String>();

        Word word;
        while ((word = mmSeg.next()) != null) {
            segmentation.add(word.getString());
        }
        return segmentation;
    }
}