package com.evcheung.apps.segmentation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "ok";
    }
}
