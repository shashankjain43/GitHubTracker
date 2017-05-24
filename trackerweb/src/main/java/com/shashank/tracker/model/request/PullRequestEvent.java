package com.shashank.tracker.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shashank.tracker.model.sro.GitHubRepository;
import com.shashank.tracker.model.sro.PullRequest;
import lombok.Data;

@Data
public class PullRequestEvent extends BaseRequest {

  private String action;
  private Integer number;
  @JsonProperty("pull_request")
  private PullRequest pullRequest;
  private GitHubRepository repository;
}
