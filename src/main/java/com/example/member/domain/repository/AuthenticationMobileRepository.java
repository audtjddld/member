package com.example.member.domain.repository;

import com.example.member.domain.entity.AuthenticationMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 전화번호 인증 Repository.
 */
@Repository
public interface AuthenticationMobileRepository extends JpaRepository<AuthenticationMobile, Long> {


  /**
   * 전화번호와 인증정보를 이용하여 조회합니다.
   */
  AuthenticationMobile findByMobileAndAuthenticationNumber(String mobile,
                                                           String authenticationNumber);

}
