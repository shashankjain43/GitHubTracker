package com.shashank.tracker.controller;

import com.shashank.tracker.exception.ExceptionCodes;
import com.shashank.tracker.exception.GenericException;
import com.shashank.tracker.model.response.BaseResponse;
import com.shashank.tracker.model.response.ServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
@Slf4j
public class BaseController {

  @ExceptionHandler(RuntimeException.class)
  public <T extends BaseResponse> ServiceResponse<T> handleExcpetion(RuntimeException exception) {
    log.error("exception caught at base controller: ", exception);
    ServiceResponse<T> response = new ServiceResponse<T>();
    GenericException ex = new GenericException();
    ex.setErrorCode(ExceptionCodes.INTERNAL_SERVER.errCode());
    ex.setErrorMsg(ExceptionCodes.INTERNAL_SERVER.errMsg());
    response.setException(ex);
    return response;
  }
}
