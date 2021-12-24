package com.example.member.application;

import com.example.member.adapter.in.web.model.LoginResponse;
import com.example.member.application.port.in.LoginUseCase;
import com.example.member.application.port.out.FindMemberEmailPasswordPort;
import com.example.member.config.TokenManager;
import com.example.member.domain.entity.User;
import com.example.member.domain.util.SHA256;
import com.example.member.exception.MemberNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 로그인 서비스.
 */
@RequiredArgsConstructor
@Service
public class LoginService implements LoginUseCase {

  private final FindMemberEmailPasswordPort port;

  private final TokenManager jwtManager;

  /**
   * 이메일 패스워드를 입력 받아 회원 정보를 조회합니다.
   *
   * @param email    이메일
   * @param password 패스워드
   * @return 토큰 정보
   */
  @Override
  public LoginResponse login(final String email, final String password) throws NoSuchAlgorithmException {

    final User user = port.findByEmailAndPassword(email, SHA256.encrypt(password));

    if (Objects.isNull(user)) {
      throw new MemberNotFoundException();
    }

    final String token = jwtManager.create(user.getId(), user.getEmail());
    return new LoginResponse(token);
  }

}
