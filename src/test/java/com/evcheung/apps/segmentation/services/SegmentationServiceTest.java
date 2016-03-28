package com.evcheung.apps.segmentation.services;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class SegmentationServiceTest {
    @Test
    public void should_analyse_text_with_mmseg_and_default_dictionary() throws Exception {
        SegmentationService segmentationService = new SegmentationService();
        String text = "为什么大多数公司成长伴随着员工自由的缩减和公司的日益官僚化";
        ArrayList<String> segments = segmentationService.mmseg(text);

        assertEquals("为什么", segments.get(0));
        assertEquals("大多数", segments.get(1));
        assertEquals("公司", segments.get(2));
        assertEquals("成长", segments.get(3));
        assertEquals("伴随", segments.get(4));
        assertEquals("着", segments.get(5));
        assertEquals("员工", segments.get(6));
        assertEquals("自由", segments.get(7));
        assertEquals("的", segments.get(8));
        assertEquals("缩减", segments.get(9));
        assertEquals("和", segments.get(10));
        assertEquals("公司", segments.get(11));
        assertEquals("的", segments.get(12));
        assertEquals("日益", segments.get(13));
        assertEquals("官僚", segments.get(14));
        assertEquals("化", segments.get(15));
    }
}
