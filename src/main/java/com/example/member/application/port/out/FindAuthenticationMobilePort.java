package com.example.member.application.port.out;

import com.example.member.domain.entity.AuthenticationMobile;

/**
 * 전화번호 인증 정보 조회 Port.
 */
public interface FindAuthenticationMobilePort {

  /**
   * 전화번호, 인증번호를 이용하여 인증 정보를 조회합니다.
   *
   * @param mobile               전화번호
   * @param authenticationNumber 인증번호
   * @return 내역이 존재하면 인증정보를 리턴하고 나머지는 null
   */
  AuthenticationMobile find(String mobile, String authenticationNumber);

}
