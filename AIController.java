package com.demo.project.AI.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin("*")
public class AIController {
	 @Value("${openai.api.key}")
	    private String apiKey;

	    @PostMapping("/ask")
	    public Map<String, String> askQuestion(
	            @RequestBody Map<String, String> request
	    ) {

	        String question = request.get("question");

	        WebClient webClient =
	                WebClient.builder()
	                        .baseUrl("https://api.openai.com")
	                        .defaultHeader(
	                                HttpHeaders.AUTHORIZATION,
	                                "Bearer " + apiKey
	                        )
	                        .build();

	        Map<String, Object> body =
	                new HashMap<>();

	        body.put("model", "gpt-4o-mini");
	        List<Map<String, String>> messages =
	                new ArrayList<>();

	        messages.add(
	                Map.of(
	                        "role",
	                        "user",
	                        "content",
	                        question
	                )
	        );

	        body.put("messages", messages);

	        Map response =
	                webClient.post()
	                        .uri("/v1/chat/completions")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .bodyValue(body)
	                        .retrieve()
	                        .bodyToMono(Map.class)
	                        .block();
	        System.out.println(response);
	        if(response == null){

	            return Map.of(
	                    "answer",
	                    "No response from AI"
	            );
	        }

	        List choices =
	                (List) response.get("choices");

	        if(choices == null || choices.isEmpty()){

	            return Map.of(
	                    "answer",
	                    "AI response not found"
	            );
	        }

	        Map firstChoice =
	                (Map) choices.get(0);

	        Map message =
	                (Map) firstChoice.get("message");

	        String answer =
	                message.get("content").toString();

	        return Map.of(
	                "answer",
	                answer
	        );
}
}
