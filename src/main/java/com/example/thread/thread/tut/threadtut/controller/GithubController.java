package com.example.thread.thread.tut.threadtut.controller;

import com.example.thread.thread.tut.threadtut.models.GithubModel;
import com.example.thread.thread.tut.threadtut.service.GithubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class GithubController {

    private final GithubService githubService;

    @PostMapping("/api/github/users/info")
    public GithubModel receiveTransactionNotification(@RequestBody String userName) {

        log.info("Event Received : {}", userName);

        return githubService.getGithubUserData(userName);
    }
}
