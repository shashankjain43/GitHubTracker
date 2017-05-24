package com.shashank.tracker.model.response;

import com.shashank.tracker.exception.GenericException;
import lombok.Data;

@Data
public class ServiceResponse<T extends BaseResponse> {

  private T response;
  private GenericException exception;

  public void setResponse(T response) {
    this.response = response;
  }
}