package com.acc.genithon.repository;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class ReviewSummaryClient {

    public String getSummary(String review) {


        OpenAiService service = new OpenAiService("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", Duration.ofSeconds(60));

        System.out.println("\nCreating completion...");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("gpt-3.5-turbo-1106")
                .prompt("write summary from the customer reviews in 1 lines. I am going to display the summary in the product page, "+ review)
                .echo(true)
                .user("testing")
                .n(3)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
        return service.createCompletion(completionRequest).getChoices().get(0).getText();
    }
}
