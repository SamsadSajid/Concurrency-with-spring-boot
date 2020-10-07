package com.example.thread.thread.tut.threadtut.api;

import com.example.thread.thread.tut.threadtut.models.GithubModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bangdao-api-service", url = "https://api.github.com")
public interface GithubAPIService {

    @GetMapping(value = "/users/{userName}")
    GithubModel getGithubUserData(@PathVariable String userName);
}
