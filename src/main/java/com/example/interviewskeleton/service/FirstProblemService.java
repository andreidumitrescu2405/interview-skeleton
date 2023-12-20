package com.example.interviewskeleton.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
@EnableAsync
public class FirstProblemService {
    private static final String FORBIDDEN_CHARACTER = "a";

    public void saveWords(List<String> words) {
        words.stream()
                .filter(word -> !containsForbiddenCharacter(word))
                .map(this::callToMethodOfExternal)
                .collect(Collectors.toList());
    }

    private void saveWordToExternalApi(String word) {
        try {
            // Here we call external API. We use a sleep of 1s to simulate that it takes a lot of time, and we have no control over it.
            Thread.sleep(1000);
        } catch (Throwable anyException) {
            log.info("[BEST EFFORT] Saving word '{}' failed: {}", word, anyException.getMessage());
        }
    }

    @Async
    public CompletableFuture<Void> callToMethodOfExternal(String word) {
        return CompletableFuture.runAsync(() -> saveWordToExternalApi(word));
    }

    private static boolean containsForbiddenCharacter(String word) {
        if (word.contains(FORBIDDEN_CHARACTER)) {
            throw new UnsupportedOperationException("This word is not valid!");
        }
        return false;
    }
}
