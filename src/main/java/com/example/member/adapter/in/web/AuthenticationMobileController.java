package com.example.member.adapter.in.web;

import com.example.member.adapter.in.web.model.AuthenticateMobileRequest;
import com.example.member.adapter.in.web.model.AuthenticateMobileResponse;
import com.example.member.application.port.in.AuthenticateMobileUseCase;
import com.example.member.application.port.in.command.AuthenticateMobileCommand;
import com.example.member.exception.BadRequestException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 모바일 검증 요청 Controller.
 */
@RequiredArgsConstructor
@RequestMapping(path = "authentications")
@RestController
public class AuthenticationMobileController {

  private final AuthenticateMobileUseCase useCase;

  /**
   * 모바일 번호를 입력 받고 인증 번호를 리턴합니다.
   *
   * @param request 모바일번호
   * @return 인증번호
   */
  @PostMapping
  public AuthenticateMobileResponse verify(
      @Valid @RequestBody final AuthenticateMobileRequest request,
      final BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      throw new BadRequestException();
    }


    return useCase.authenticate(new AuthenticateMobileCommand(request.getMobile()));
  }

}
