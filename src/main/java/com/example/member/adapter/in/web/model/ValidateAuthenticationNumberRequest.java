package com.example.member.adapter.in.web.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 인증번호 검증 요청.
 */
@Setter
@Getter
public class ValidateAuthenticationNumberRequest {

  @NotNull
  @NotEmpty
  @Size(max = 6)
  private String authenticationNumber;

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$")
  private String mobile;

}
