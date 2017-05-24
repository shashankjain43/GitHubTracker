package com.shashank.tracker.service.impl;

import com.shashank.tracker.dao.IPullRequestDao;
import com.shashank.tracker.entity.PullRequestDO;
import com.shashank.tracker.model.request.GetPullRequestDetailsRequest;
import com.shashank.tracker.model.request.PullRequestEvent;
import com.shashank.tracker.model.response.AddPullRequestResponse;
import com.shashank.tracker.model.response.GetPullRequestResponse;
import com.shashank.tracker.model.sro.PullRequest;
import com.shashank.tracker.model.sro.PullRequestSRO;
import com.shashank.tracker.service.IPullRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PullRequestServiceImpl implements IPullRequestService {

  @Autowired
  private IPullRequestDao pullRequestDao;

  @Override
  public GetPullRequestResponse getPullRequestDetails(Integer pullRequestId) {
    GetPullRequestResponse response = new GetPullRequestResponse();
    PullRequestDO entity = pullRequestDao.getPullRequestDOByPullRequestId(pullRequestId);
    PullRequestSRO sro = getPullRequestSROFromEntity(entity);
    response.setPullRequest(sro);
    return response;
  }

  @Override
  public AddPullRequestResponse addPullRequest(PullRequestEvent payload) {
    AddPullRequestResponse response = new AddPullRequestResponse();
    PullRequestDO entity = preparePullRequestDOFromEventPayload(payload);
    pullRequestDao.save(entity);
    return response;
  }

  private PullRequestDO preparePullRequestDOFromEventPayload(PullRequestEvent payload) {
    PullRequest pullRequest = payload.getPullRequest();
    PullRequestDO entity = pullRequestDao
        .getPullRequestDOByPullRequestId(pullRequest.getPullRequestId());
    if (entity == null) {
      entity = new PullRequestDO();
    }
    entity.setPullRequestId(pullRequest.getPullRequestId());
    entity.setNumber(pullRequest.getNumber());
    entity.setTitle(pullRequest.getTitle());
    entity.setBody(pullRequest.getBody());
    entity.setState(pullRequest.getState());
    entity.setCreated(pullRequest.getCreatedAt());
    entity.setUpdated(pullRequest.getUpdatedAt());
    entity.setMergedAt(pullRequest.getMergedAt());
    entity.setClosedAt(pullRequest.getClosedAt());
    return entity;
  }

  private PullRequestSRO getPullRequestSROFromEntity(PullRequestDO entity) {
    if (entity == null) {
      return null;
    }
    PullRequestSRO sro = new PullRequestSRO();
    sro.setNumber(entity.getNumber());
    sro.setBody(entity.getBody());
    sro.setState(entity.getState());
    sro.setTitle(entity.getTitle());
    sro.setClosedAt(entity.getClosedAt());
    sro.setCreatedAt(entity.getCreated());
    sro.setMergedAt(entity.getMergedAt());
    sro.setUpdatedAt(entity.getUpdated());
    return sro;
  }
}