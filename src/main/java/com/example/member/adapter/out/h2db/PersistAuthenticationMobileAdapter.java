package com.example.member.adapter.out.h2db;

import com.example.member.application.port.out.PersistAuthenticationMobilePort;
import com.example.member.common.Adapter;
import com.example.member.domain.entity.AuthenticationMobile;
import com.example.member.domain.repository.AuthenticationMobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 전화번호 인증 정보를 생성합니다.
 */
@RequiredArgsConstructor
@Adapter
public class PersistAuthenticationMobileAdapter implements PersistAuthenticationMobilePort {

  private final AuthenticationMobileRepository repository;

  @Transactional
  @Override
  public AuthenticationMobile save(final String mobile) {
    return repository.save(new AuthenticationMobile(mobile));
  }

}
