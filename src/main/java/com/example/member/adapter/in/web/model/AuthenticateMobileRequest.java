package com.example.member.adapter.in.web.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * 검증 요청 모델.
 */
@Setter
@Getter
public class AuthenticateMobileRequest {

  @NotEmpty
  @NotNull
  @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$")
  private String mobile;

}
