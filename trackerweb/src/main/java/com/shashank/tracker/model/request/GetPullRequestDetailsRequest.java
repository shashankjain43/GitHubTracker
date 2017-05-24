package com.shashank.tracker.model.request;

import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

@Data
public class GetPullRequestDetailsRequest extends BaseRequest {

  @NotNull(message = "Provided pullRequestId is blank!")
  private Integer pullRequestId;
}
