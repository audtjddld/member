package com.example.member.domain.entity;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

/**
 * 휴대번호 인증 테이블.
 */
@Getter
@Entity(name = "authentication_mobile")
public class AuthenticationMobile {

  /**
   * 아이디.
   */
  @Id
  @Column(unique = true, updatable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * 휴대번호.
   */
  @Column(nullable = false)
  private String mobile;

  /**
   * 인증문자.
   */
  @Column(name = "authentication_number", nullable = false)
  private String authenticationNumber;

  /**
   * 등록일시.
   */
  @Column(name = "registed_at")
  private LocalDateTime registeredAt;


  /**
   * 휴대폰 검증 데이터를 생성합니다.
   *
   * @param mobile 휴대번호
   */
  public AuthenticationMobile(final String mobile) {
    this.mobile = mobile;
    this.authenticationNumber = createAuthenticationNumber();
    this.registeredAt = LocalDateTime.now();
  }

  protected AuthenticationMobile() {

  }

  /**
   * 인증 번호 생성 합니다.
   *
   * @return 6자리의 인증 숫자를 리턴합니다.
   */
  private String createAuthenticationNumber() {
    final StringBuilder data = new StringBuilder();
    final String charset = "0123456789";
    final SecureRandom random = new SecureRandom();

    for (int i = 0; i < 6; i++) {
      final int index = random.nextInt(charset.length());
      data.append(charset.charAt(index));
    }
    return data.toString();
  }

}
