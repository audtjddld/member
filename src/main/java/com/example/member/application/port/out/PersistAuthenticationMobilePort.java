package com.example.member.application.port.out;

import com.example.member.domain.entity.AuthenticationMobile;

/**
 * 인증 정보 저장 Port.
 */
public interface PersistAuthenticationMobilePort {

  /**
   * 인증 정보를 저장합니다.
   *
   * @param mobile 전화번호
   * @return 인증문자
   */
  AuthenticationMobile save(String mobile);

}
