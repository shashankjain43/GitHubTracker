package com.shashank.tracker.dao;

import com.shashank.tracker.entity.PullRequestDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPullRequestDao extends CrudRepository<PullRequestDO, Integer> {

  PullRequestDO getPullRequestDOByPullRequestId(Integer pullRequestId);
}