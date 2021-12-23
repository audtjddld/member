package com.example.member.application.port.in;

import com.example.member.adapter.in.web.model.LoginResponse;
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
  LoginResponse login(String email, String password) throws NoSuchAlgorithmException;

}
