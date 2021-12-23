package com.example.member.application.port.in.command;

import lombok.Getter;

/**
 * 유저 profile 커멘드.
 */
@Getter
public class UserProfileCommand {

  private final long id;

  /**
   * 유저 profile 커멘드를 생성합니다.
   *
   * @param id 사용자 아이디
   */
  public UserProfileCommand(final long id) {
    this.id = id;
  }

}
