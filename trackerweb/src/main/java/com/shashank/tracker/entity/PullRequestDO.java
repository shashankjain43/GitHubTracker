package com.shashank.tracker.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pull_request")
public class PullRequestDO implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "number")
  private Integer number;

  @Column(name = "pull_request_id")
  private Integer pullRequestId;

  @Column(name = "state", nullable = false)
  private String state;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "body")
  private String body;

  @Column(name = "closed_at")
  private Date closedAt;

  @Column(name = "merged_at")
  private Date mergedAt;

  @Column(name = "created_at")
  private Date created;

  @Column(name = "updated_at")
  private Date updated;
}