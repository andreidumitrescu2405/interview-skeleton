package com.example.interviewskeleton.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@Slf4j
public class ThirdProblemService {

    @Value("${greeting.morning.en}")
    private String morningEn;

    @Value("${greeting.morning.es}")
    private String morningEs;

    @Value("${greeting.afternoon.en}")
    private String afternoonEn;

    @Value("${greeting.afternoon.es}")
    private String afternoonEs;

    @Value("${greeting.evening.en}")
    private String eveningEn;

    @Value("${greeting.evening.es}")
    private String eveningEs;

    public ResponseEntity<String> getGreeting(String name, String locale, String authToken) {
        if (!"such-secure-much-wow".equals(authToken)) {
            return ResponseEntity.status(403).body("Forbidden: Invalid or missing X-Auth-Token header");
        }
        String timeOfDay = getTimeOfDay();
        String greetingType =  switch (timeOfDay) {
            case "morning" -> locale.equals("en") ? morningEn : morningEs;
            case "afternoon" -> locale.equals("en") ? afternoonEn : afternoonEs;
            case "evening" -> locale.equals("en") ? eveningEn : eveningEs;
            default -> "Default greeting";
        };
        String greetingMessage = greetingType.replace("{name}", name);
        return ResponseEntity.ok(greetingMessage);
    }

    private String getTimeOfDay() {
        int hour = LocalTime.now().getHour();
        if (hour >= 6 && hour < 12) {
            return "morning";
        } else if (hour >= 12 && hour < 18) {
            return "afternoon";
        } else {
            return "evening";
        }
    }
}
