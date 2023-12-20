package com.example.interviewskeleton.controller;

import com.example.interviewskeleton.service.ThirdProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ThirdProblemController {

    private final ThirdProblemService thirdProblemService;

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name, @RequestParam(defaultValue = "en") String locale) {
        return thirdProblemService.getGreeting(name, locale);
    }
}
