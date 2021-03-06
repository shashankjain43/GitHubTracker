package com.shashank.tracker.service.impl;

import com.shashank.tracker.dao.IPullRequestDao;
import com.shashank.tracker.entity.PullRequestDO;
import com.shashank.tracker.exception.ExceptionCodes;
import com.shashank.tracker.exception.ValidationException;
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
    if (payload == null) {
      log.info(ExceptionCodes.PAYLOAD_MISSING.errMsg());
      throw new ValidationException(ExceptionCodes.PAYLOAD_MISSING.errCode(),
          ExceptionCodes.PAYLOAD_MISSING.errMsg());
    }
    PullRequestDO entity = preparePullRequestDOFromEventPayload(payload);
    pullRequestDao.save(entity);
    response.setSuccess(true);
    return response;
  }

  private PullRequestDO preparePullRequestDOFromEventPayload(PullRequestEvent payload) {
    PullRequest pullRequest = payload.getPullRequest();
    if (pullRequest == null) {
      log.info(ExceptionCodes.PULL_REQUEST_MISSING.errMsg() + " hence ignoring this payload!");
      throw new ValidationException(ExceptionCodes.PULL_REQUEST_MISSING.errCode(),
          ExceptionCodes.PULL_REQUEST_MISSING.errMsg());
    }
    log.info("Received payload is: " + payload);
    PullRequestDO entity = pullRequestDao
        .getPullRequestDOByPullRequestId(pullRequest.getPullRequestId());
    if (entity == null) {
      entity = new PullRequestDO();
    }
    entity.setPullRequestId(pullRequest.getPullRequestId());
    entity.setNumber(pullRequest.getNumber());
    entity.setRepoId(payload.getRepository() != null ? payload.getRepository().getRepoId() : null);
    entity.setRepoFullName(
        payload.getRepository() != null ? payload.getRepository().getFullName() : null);
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
    sro.setPullRequestId(entity.getPullRequestId());
    sro.setRepoId(entity.getRepoId());
    sro.setRepoFullName(entity.getRepoFullName());
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