package com.example.member.application.port.out;

import com.example.member.domain.entity.Member;

/**
 * 회원 조회 Port.
 */
public interface FindMemberPort {

  /**
   * 이메일을 입력받아 가입된 회원이 있는지 조회합니다.
   *
   * @param email 이메일 주소
   * @return 가입된 내역이 있으면 회원 정보, 없으면 null
   */
  Member find(String email);

}
