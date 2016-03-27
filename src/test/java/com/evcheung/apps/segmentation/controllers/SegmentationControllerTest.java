package com.evcheung.apps.segmentation.controllers;

import com.evcheung.apps.segmentation.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class SegmentationControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void should_analyse_text_with_segmentation() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Map payload = new HashMap<String, String>();
        payload.put("text", "天空一无所有,为何给我安慰");
        String content = mapper.writeValueAsString(payload);

        ResultActions perform = mockMvc.perform(post("/segmentation").content(content).contentType(MediaType.APPLICATION_JSON_VALUE));
        perform
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(0))
                .andExpect(jsonPath("$.data.segments[0]").value("天空"))
                .andExpect(jsonPath("$.data.segments[1]").value("一无所有"))
                .andExpect(jsonPath("$.data.segments[2]").value("为何"))
                .andExpect(jsonPath("$.data.segments[3]").value("给我"))
                .andExpect(jsonPath("$.data.segments[4]").value("安慰"));
    }
}
