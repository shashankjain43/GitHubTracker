package com.shashank.tracker.controller;

import com.shashank.tracker.model.request.PullRequestEvent;
import com.shashank.tracker.model.request.GetPullRequestDetailsRequest;
import com.shashank.tracker.model.response.AddPullRequestResponse;
import com.shashank.tracker.model.response.GetPullRequestResponse;
import com.shashank.tracker.model.response.ServiceResponse;
import com.shashank.tracker.service.IPullRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/pullRequest")
public class PullRequestController {

  @Autowired
  private IPullRequestService service;

  @RequestMapping(value = "/getDetails/{pullRequestId}", produces = "application/json", method = RequestMethod.GET)
  public ServiceResponse<GetPullRequestResponse> getPullRequestDetails(@PathVariable("pullRequestId") Integer pullRequestId) {
    ServiceResponse<GetPullRequestResponse> serviceResponse = new ServiceResponse<GetPullRequestResponse>();
    GetPullRequestResponse res = service.getPullRequestDetails(pullRequestId);
    serviceResponse.setResponse(res);
    return serviceResponse;
  }

  @RequestMapping(value = "/receive", produces = "application/json", method = RequestMethod.POST)
  public ServiceResponse<AddPullRequestResponse> addPullRequest(
      @RequestBody PullRequestEvent request) {
    ServiceResponse<AddPullRequestResponse> serviceResponse = new ServiceResponse<AddPullRequestResponse>();
    AddPullRequestResponse res = service.addPullRequest(request);
    serviceResponse.setResponse(res);
    return serviceResponse;
  }
}