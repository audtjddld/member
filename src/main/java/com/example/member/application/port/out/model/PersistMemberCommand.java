package com.example.member.application.port.out.model;

import lombok.Builder;
import lombok.Getter;

/**
 * 회원 정보 저장 Port Command.
 */
@Getter
public class PersistMemberCommand {

  private final String email;
  private final String nickname;
  private final String password;
  private final String name;
  private final String mobile;

  /**
   * 회원 정보 저장 Port Command를 생성합니다.
   *
   * @param email    이메일
   * @param nickname 닉네임
   * @param password 패스워드
   * @param name     성명
   * @param mobile   전화번호
   */
  @Builder
  public PersistMemberCommand(final String email,
                              final String nickname,
                              final String password,
                              final String name,
                              final String mobile) {
    this.email = email;
    this.nickname = nickname;
    this.password = password;
    this.name = name;
    this.mobile = mobile;
  }

}
