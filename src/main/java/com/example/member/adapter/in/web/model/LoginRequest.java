package com.example.member.adapter.in.web.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

/**
 * 로그인 요청.
 */
@Data
public class LoginRequest {

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^[_0-9a-zA-Z-]+@[0-9a-zA-Z]+(.[_0-9a-zA-Z-]+)*$")
  private String email;

  @NotNull
  @NotEmpty
  private String password;

}
