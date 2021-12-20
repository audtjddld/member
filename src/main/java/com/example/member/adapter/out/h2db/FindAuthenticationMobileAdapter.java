package com.example.member.adapter.out.h2db;

import com.example.member.application.port.out.FindAuthenticationMobilePort;
import com.example.member.common.Adapter;
import com.example.member.domain.entity.AuthenticationMobile;
import com.example.member.domain.repository.AuthenticationMobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 전화번호 인증 Adapter.
 */
@RequiredArgsConstructor
@Adapter
public class FindAuthenticationMobileAdapter implements FindAuthenticationMobilePort {

  private AuthenticationMobileRepository repository;

  @Transactional(readOnly = true)
  @Override
  public AuthenticationMobile find(final String mobile, final String authenticationNumber) {
    return repository.findByMobileAndAuthenticationNumber(mobile, authenticationNumber);
  }

}
