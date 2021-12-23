package com.example.member.application.port.in;

import com.example.member.application.port.in.command.UserProfileCommand;
import com.example.member.application.port.in.command.UserProfileResponse;

/**
 * 사용자 profile 조회 UseCase.
 */
public interface UserProfileUseCase {

  /**
   * 사용자 profile을 조회합니다.
   *
   * @param command 사용자 profile 조회 command
   * @return 유효하면 사용자 정보, 아니면 예외
   */
  UserProfileResponse profile(UserProfileCommand command);

}
