package com.example.member.application.port.in.command;

import lombok.Builder;
import lombok.Getter;

/**
 * 사용자 profile 응답.
 */
@Getter
public class UserProfileResponse {

  private final String email;
  private final String nickname;
  private final String name;
  private final String mobile;

  /**
   * 사용자 Profile 응답을 생성합니다.
   *
   * @param email    이메일
   * @param nickname 닉네임
   * @param name     성명
   * @param mobile   휴대번호
   */
  @Builder
  public UserProfileResponse(final String email,
                             final String nickname,
                             final String name,
                             final String mobile) {
    this.email = email;
    this.nickname = nickname;
    this.name = name;
    this.mobile = mobile;
  }

}
