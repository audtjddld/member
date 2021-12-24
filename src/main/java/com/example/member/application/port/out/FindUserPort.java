package com.example.member.application.port.out;

import com.example.member.domain.entity.User;

/**
 * 회원 조회 Port.
 */
public interface FindUserPort {

  /**
   * 이메일을 입력받아 가입된 회원이 있는지 조회합니다.
   *
   * @param email 이메일 주소
   * @return 가입된 내역이 있으면 회원 정보, 없으면 null
   */
  User find(String email);

}
