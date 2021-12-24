package com.example.member.application.port.out;

import com.example.member.application.port.out.model.PersistMemberCommand;
import com.example.member.domain.entity.User;

/**
 * 회원 정보 저장 Port.
 */
public interface PersistUserPort {

  /**
   * 회원 정보를 저장합니다.
   *
   * @param command 회원정보 저장 커멘드.
   */
  User save(PersistMemberCommand command);

}
