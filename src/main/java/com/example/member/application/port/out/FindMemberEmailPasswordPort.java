package com.example.member.application.port.out;

import com.example.member.domain.entity.Member;

/**
 * 회원 정보 조회 Port
 * email과 password를 이용해서 조회합니다.
 */
public interface FindMemberEmailPasswordPort {

  /**
   * 이메일과 패스워드를 입력받아 회원을 조회합니다.
   *
   * @param email    이메일 주소
   * @param password 패스워드
   * @return 정보가 일치하면 회원 정보, 없으면 null
   */
  Member findByEmailAndPassword(String email, String password);

}
