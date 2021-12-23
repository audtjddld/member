package com.example.member.adapter.in.web;

import com.example.member.adapter.in.web.model.LoginRequest;
import com.example.member.adapter.in.web.model.LoginResponse;
import com.example.member.application.port.in.LoginUseCase;
import com.example.member.exception.BadRequestException;
import java.security.NoSuchAlgorithmException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 로그인 컨트롤러.
 */
@RequiredArgsConstructor
@RequestMapping(path = "/login")
@RestController
public class LoginController {

  private final LoginUseCase useCase;

  /**
   * 이메일과 패스워드를 입력받아 인증 토큰을 발행합니다.
   *
   * @param request       로그인 요청
   * @param bindingResult 파라미터 검증
   * @return 정상이면 토큰, 나머지 MemberNotFoundException 예외 404 응답
   */
  @PostMapping
  public LoginResponse login(final @Valid @RequestBody LoginRequest request,
                             final BindingResult bindingResult) throws NoSuchAlgorithmException {

    if (bindingResult.hasErrors()) {
      throw new BadRequestException();
    }

    return useCase.login(request.getEmail(), request.getPassword());
  }

}
