package com.shashank.tracker.model.sro;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class PullRequestSRO implements Serializable {

  private Integer number;
  private Integer pullRequestId;
  private Integer repoId;
  private String repoFullName;
  private String state;
  private String title;
  private String body;
  private Date closedAt;
  private Date mergedAt;
  private Date createdAt;
  private Date updatedAt;
}