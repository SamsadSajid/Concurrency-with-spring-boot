package com.example.thread.thread.tut.threadtut.service;

import com.example.thread.thread.tut.threadtut.models.GithubModel;

import java.util.Optional;

public interface GithubService {
    GithubModel getGithubUserData(String userName);
}
