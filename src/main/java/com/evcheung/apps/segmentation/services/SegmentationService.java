package com.evcheung.apps.segmentation.services;

import com.chenlb.mmseg4j.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

@Component
public class SegmentationService {
    public ArrayList<String> mmseg(String text) throws IOException {
        Dictionary dic = Dictionary.getInstance();
        Seg seg = new ComplexSeg(dic);
        MMSeg mmSeg = new MMSeg(new StringReader(text), seg);

        ArrayList<String> segmentation = new ArrayList<String>();

        Word word;
        while ((word = mmSeg.next()) != null) {
            segmentation.add(word.getString());
        }
        return segmentation;
    }
}