package com.shashank.tracker.model.response;

import com.shashank.tracker.model.sro.PullRequestSRO;
import lombok.Data;

@Data
public class GetPullRequestResponse extends BaseResponse {

  private PullRequestSRO pullRequest;
}