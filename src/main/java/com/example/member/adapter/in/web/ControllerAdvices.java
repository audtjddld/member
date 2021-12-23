package com.example.member.adapter.in.web;

import com.example.member.exception.BadRequestException;
import com.example.member.exception.BusinessException;
import com.example.member.exception.NotPermimtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handler.
 */
@ControllerAdvice(basePackages = "com.example.member")
public class ControllerAdvices {

  /**
   * 400 오류 메시지를 반환합니다.
   *
   * @param be BusinessException
   * @return http Status 400, 메시지
   */
  @ExceptionHandler(value = {BadRequestException.class, NotPermimtException.class})
  public ResponseEntity<String> badRequest(final BusinessException be) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(be.getMessage());
  }

}
