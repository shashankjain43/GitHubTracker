package com.shashank.tracker.exception;

public class ValidationException extends GenericException {

  public ValidationException(String errorCode, String errorMsg) {
    super(errorCode, errorMsg);
  }
}
