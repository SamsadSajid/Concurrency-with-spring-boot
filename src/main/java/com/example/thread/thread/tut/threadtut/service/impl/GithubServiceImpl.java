package com.example.thread.thread.tut.threadtut.service.impl;

import com.example.thread.thread.tut.threadtut.api.GithubAPIService;
import com.example.thread.thread.tut.threadtut.models.GithubModel;
import com.example.thread.thread.tut.threadtut.service.GithubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class GithubServiceImpl implements GithubService {

    private final GithubAPIService githubAPIService;

    @Override
    public GithubModel getGithubUserData(String userName) {

        Callable<GithubModel> githubAPICallingTask = () -> {
            log.info("Calling Github API for user name {}", userName);

            GithubModel githubModel = githubAPIService.getGithubUserData(userName);
            log.info("Github response is {}", githubModel.toString());

            return githubModel;
        };

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        ScheduledFuture<GithubModel> githubModelScheduledFuture =
                scheduledExecutorService.schedule(githubAPICallingTask, 5, TimeUnit.SECONDS);

        log.info("before {}", scheduledExecutorService.toString());
        scheduledExecutorService.shutdown();
        log.info("after {}", scheduledExecutorService.toString());

        try {
            return githubModelScheduledFuture.get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
