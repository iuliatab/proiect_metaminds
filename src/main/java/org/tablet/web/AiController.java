package org.tablet.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tablet.service.AiService;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/chat")
    public ResponseEntity<Map<String, String>> chatWithAi(@RequestBody Map<String, String> request) {

        String mesajClient = request.get("message");
        System.out.println("Clientul întreabă: " + mesajClient);

        String raspunsAi = aiService.getRecommendations(mesajClient);

        return ResponseEntity.ok(Map.of("response", raspunsAi));
    }
}