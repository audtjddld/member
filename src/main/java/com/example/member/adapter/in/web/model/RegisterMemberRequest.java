package com.example.member.adapter.in.web.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * 회원 가입 요청.
 */
@Setter
@Getter
public class RegisterMemberRequest {

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^[_0-9a-zA-Z-]+@[0-9a-zA-Z]+(.[_0-9a-zA-Z-]+)*$")
  private String email;

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$")
  private String nickname;

  @NotNull
  @NotEmpty
  private String password;

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^[ㄱ-ㅎ가-힣]*$")
  private String name;

  @NotNull
  @NotEmpty
  @Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$")
  private String mobile;

}
