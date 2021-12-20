package com.example.member.application;

import com.example.member.adapter.in.web.model.AuthenticateMobileResponse;
import com.example.member.application.port.in.AuthenticateMobileUseCase;
import com.example.member.application.port.in.command.AuthenticateMobileCommand;
import com.example.member.application.port.out.PersistAuthenticationMobilePort;
import com.example.member.domain.entity.AuthenticationMobile;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * 전화번호 인증 UseCase 구현체.
 */
@RequiredArgsConstructor
@Service
public class AuthenticateService implements AuthenticateMobileUseCase {

  private final PersistAuthenticationMobilePort port;

  @Transactional
  @Override
  public AuthenticateMobileResponse authenticate(final AuthenticateMobileCommand command) {
    final AuthenticationMobile authenticationMobile = port.save(command.getMobile());
    return new AuthenticateMobileResponse(authenticationMobile.getAuthenticationNumber());
  }

}
