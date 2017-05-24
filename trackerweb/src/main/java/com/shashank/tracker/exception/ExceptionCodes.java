package com.shashank.tracker.exception;

public enum ExceptionCodes {

  VALIDATION("ER-999", "Invalid fields in request!"),
  INTERNAL_SERVER("ER-3100", "System Error! Please try after some time"),;

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
