package com.example.interviewskeleton.controller;

import com.example.interviewskeleton.service.ThirdProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ThirdProblemController {

    private final ThirdProblemService thirdProblemService;

    @GetMapping("/greet/{name}")
    public ResponseEntity<String> greet(@PathVariable String name, @RequestParam(defaultValue = "en") String locale, @RequestHeader(name = "X-Auth-Token", required = false) String authToken) {
        return thirdProblemService.getGreeting(name, locale, authToken);
    }
}
