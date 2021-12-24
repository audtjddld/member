package com.example.member.adapter.in.web.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * 패스워드 변경 요청.
 */
@Data
public class ChangePasswordRequest {

  @NotNull
  @NotEmpty
  private Long id;

  @NotNull
  @NotEmpty
  private String password;
  
  @NotNull
  @NotEmpty
  private String confirmPassword;

}
