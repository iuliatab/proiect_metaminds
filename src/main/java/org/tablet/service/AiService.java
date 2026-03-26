package org.tablet.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    public String getRecommendations(String userMessage) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String promptPersonalizat = "Ești AlegeSmart, un asistent virtual expert pentru un magazin de electronice din România. " +
                    "Răspunde foarte prietenos, scurt și la obiect (maxim 3-4 propoziții). " +
                    "Recomandă laptopuri, telefoane sau accesorii în funcție de nevoia clientului. " +
                    "Întrebarea clientului este: " + userMessage;

            Map<String, Object> requestBody = Map.of(
                    "contents", List.of(
                            Map.of("parts", List.of(
                                    Map.of("text", promptPersonalizat)
                            ))
                    )
            );

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

            Map<String, Object> response = restTemplate.postForObject(apiUrl + apiKey, request, Map.class);

            List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.get("candidates");
            Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");
            List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");

            return (String) parts.get(0).get("text");

        } catch (Exception e) {
            System.out.println("Eroare la conectarea cu Gemini: " + e.getMessage());
            return "Ne pare rău, asistentul este momentan indisponibil. Încearcă din nou!";
        }
    }
}