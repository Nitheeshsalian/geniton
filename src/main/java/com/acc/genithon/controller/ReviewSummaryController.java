package com.acc.genithon.controller;

import com.acc.genithon.service.ReviewSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewSummaryController {

    @Autowired
    private ReviewSummaryService service;

    @GetMapping("/summary")
    public String getSummary(@RequestParam("name") String productName) {
        return service.getSummary(productName);
    }
}
