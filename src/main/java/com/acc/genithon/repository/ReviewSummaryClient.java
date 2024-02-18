package com.acc.genithon.repository;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ReviewSummaryClient {

    public String getSummary(String review) {

        if(Strings.isBlank(review)) {
            return "Product review not available";
        }

        OpenAiService service = new OpenAiService("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", Duration.ofSeconds(6000));

        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "write summary and tags  from the customer reviews in 1 lines. I am going to display the summary in the product page, " + review);
        messages.add(systemMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .build();

        StringBuilder builder = new StringBuilder();
        service.streamChatCompletion(chatCompletionRequest)
                .doOnError(Throwable::printStackTrace)
                .blockingForEach(req -> {
                    ChatMessage message = req.getChoices().get(0).getMessage();
                    System.out.println( message.getContent());
                    builder.append(message.getContent());
                });
        System.out.println("\nCreating completion...");
        return builder.toString();
    }
}
