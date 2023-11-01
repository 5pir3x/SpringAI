package com.example.springai;

import org.springframework.ai.client.AiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class AIController {
    private final AiClient aiClient;

    @Autowired
    public AIController(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    @GetMapping("/ask")
    public String answer(@RequestParam("question") String question) {
        return aiClient.generate(question);
    }
}
