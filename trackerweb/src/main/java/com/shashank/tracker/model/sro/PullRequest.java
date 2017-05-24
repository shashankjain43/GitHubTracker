package com.shashank.tracker.model.sro;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class PullRequest implements Serializable {

  private String url;
  @JsonProperty("id")
  private Integer pullRequestId;
  @JsonProperty("html_url")
  private String htmlUrl;
  private Integer number;
  private String state;
  private String title;
  private String body;
  @JsonProperty("created_at")
  private Date createdAt;
  @JsonProperty("updated_at")
  private Date updatedAt;
  @JsonProperty("closed_at")
  private Date closedAt;
  @JsonProperty("merged_at")
  private Date mergedAt;
  private Boolean merged;
}
