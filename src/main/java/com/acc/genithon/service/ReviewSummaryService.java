package com.acc.genithon.service;

import com.acc.genithon.model.Item;
import com.acc.genithon.repository.ReviewSummaryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewSummaryService {

    @Autowired
    private ItemService service;

    @Autowired
    private ReviewSummaryClient client;

    public String getSummary(String productName) {
        Item item = service.getItem(productName);
        return client.getSummary(item.getValue());
    }
}
