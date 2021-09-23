package com.sca.http;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;

import java.util.List;

// It fails with 404
public class GitLabApiExample {

    public static void main(String[] args) throws GitLabApiException {
        // Create a GitLabApi instance to communicate with your GitLab server
        GitLabApi gitLabApi = new GitLabApi("https://gitlab.com/api/v4/", "84QcngsBhNKRi9Kf_Rsr");
        List<Project> projects = gitLabApi.getProjectApi().getProjects();

        System.out.println("LIst projects: " + projects.size());
    }
}
