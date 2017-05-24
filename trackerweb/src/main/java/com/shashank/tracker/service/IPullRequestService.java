package com.shashank.tracker.service;

import com.shashank.tracker.model.request.PullRequestEvent;
import com.shashank.tracker.model.request.GetPullRequestDetailsRequest;
import com.shashank.tracker.model.response.AddPullRequestResponse;
import com.shashank.tracker.model.response.GetPullRequestResponse;

public interface IPullRequestService {

  public GetPullRequestResponse getPullRequestDetails(Integer pullRequestId);

  public AddPullRequestResponse addPullRequest(PullRequestEvent request);
}