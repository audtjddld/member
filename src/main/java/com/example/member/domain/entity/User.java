package com.example.member.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity(name = "user")
public class User {

  /**
   * 회원 아이디.
   */
  @Id
  @Column(unique = true)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * 이메일.
   */
  @Column(unique = true, nullable = false)
  private String email;

  /**
   * 닉네임.
   */
  @Column(unique = true, updatable = false)
  private String nickname;

  /**
   * 비밀번호.
   */
  @Column(nullable = false)
  private String password;

  /**
   * 이름.
   */
  @Column(nullable = false)
  private String name;

  /**
   * 전화번호.
   */
  @Column(nullable = false)
  private String mobile;

  /**
   * 등록일시.
   */
  @Column(name = "registered_at")
  private LocalDateTime registeredAt;

  /**
   * 회원 정보를 생성합니다.
   *
   * @param email    이메일
   * @param nickname 닉네임
   * @param password 패스워드
   * @param name     성명
   * @param mobile   전화번호
   */
  @Builder
  public User(final String email,
              final String nickname,
              final String password,
              final String name,
              final String mobile) {
    this.email = email;
    this.nickname = nickname;
    this.password = password;
    this.name = name;
    this.mobile = mobile;
    this.registeredAt = LocalDateTime.now();
  }

  protected User() {

  }

  public void updatePassword(final String password) {
    this.password = password;
  }

}
