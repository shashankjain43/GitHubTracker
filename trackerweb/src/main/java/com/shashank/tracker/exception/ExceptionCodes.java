package com.shashank.tracker.exception;

public enum ExceptionCodes {

  VALIDATION("ER-999", "Invalid fields in request!"),
  PAYLOAD_MISSING("ER-5001", "Input Payload is null or empty!"),
  PULL_REQUEST_MISSING("ER-5002", "PullRequest details is missing!"),
  PULL_REQUEST_ID_MISSING("ER-5003", "pullRequestId is missing!"),
  INTERNAL_SERVER("ER-3100", "System Error! Please try after some time");

  private String errCode;
  private String errMsg;

  private ExceptionCodes(String errCode, String errMsg) {
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

  public String errCode() {
    return this.errCode;
  }

  public String errMsg() {
    return this.errMsg;
  }
}
