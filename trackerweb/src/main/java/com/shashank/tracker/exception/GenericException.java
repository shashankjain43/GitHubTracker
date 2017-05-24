package com.shashank.tracker.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties({"cause", "stackTrace", "message", "localizedMessage", "suppressed"})
public class GenericException extends RuntimeException {

  private String errorCode;
  private String errorMsg;

  public GenericException(String errorMsg) {
    super(errorMsg);
    this.errorMsg = errorMsg;
  }

  public GenericException(String errorCode, String errorMsg) {
    super(errorMsg);
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }
}
