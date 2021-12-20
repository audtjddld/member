package com.example.member.application;

import com.example.member.adapter.in.web.model.ValidationAuthenticationNumberResponse;
import com.example.member.application.port.in.ValidateAuthenticationNumberUseCase;
import com.example.member.application.port.in.command.ValidateAuthenticationNumberCommand;
import com.example.member.application.port.out.FindAuthenticationMobilePort;
import com.example.member.domain.entity.AuthenticationMobile;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 인증문자 검증 UseCase 구현체.
 */
@RequiredArgsConstructor
@Service
public class ValidateNumberService implements ValidateAuthenticationNumberUseCase {

  private final FindAuthenticationMobilePort port;

  @Transactional(readOnly = true)
  @Override
  public ValidationAuthenticationNumberResponse validate
      (final ValidateAuthenticationNumberCommand command) {

    final AuthenticationMobile authenticationMobile =
        port.find(command.getMobile(), command.getAuthenticationNumber());

    //TODO 제한 시간으로 검증하는 것은 추가하지 않았습니다.

    return new ValidationAuthenticationNumberResponse(Objects.nonNull(authenticationMobile));
  }

}
