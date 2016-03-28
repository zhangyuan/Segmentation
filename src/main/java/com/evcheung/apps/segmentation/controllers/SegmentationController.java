package com.evcheung.apps.segmentation.controllers;

import com.evcheung.apps.segmentation.services.SegmentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@EnableWebMvc
@RequestMapping(path = "/segmentation", produces =  "application/json;charset=UTF-8")
public class SegmentationController {
    @Autowired
    private SegmentationService segmentationService;

    @RequestMapping(method = RequestMethod.POST, headers ={"Accept=application/json"}, produces =  "application/json;charset=UTF-8")
    public DataResponse create(@RequestBody SegmentationRequest request) throws IOException {
        ArrayList<String> segmentation = segmentationService.mmseg(request.getText());

        SegmentationResponse segmentationResponse = new SegmentationResponse();
        segmentationResponse.setSegments(segmentation);

        return new DataResponse(0, segmentationResponse);
    }
}
