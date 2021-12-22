package com.example.member.application.port.in;

import java.security.NoSuchAlgorithmException;

/**
 * 회원 로그인 UseCase.
 */
public interface LoginUseCase {

  /**
   * 회원 로그인을 처리합니다.
   *
   * @param email    이메일
   * @param password 패스워드
   * @return 정상처리 token 리턴합니다.
   */
  String login(String email, String password) throws NoSuchAlgorithmException;

}
