package com.shashank.tracker.model.sro;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * Created by shashank on 24/5/17.
 */
@Data
public class GitHubRepository implements Serializable {

  @JsonProperty("id")
  private Integer repoId;
  private String name;
  @JsonProperty("full_name")
  private String fullName;
}
