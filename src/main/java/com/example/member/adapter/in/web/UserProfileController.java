package com.example.member.adapter.in.web;

import com.example.member.application.port.in.UserProfileUseCase;
import com.example.member.application.port.in.command.UserProfileCommand;
import com.example.member.application.port.in.command.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 유저 프로파일 컨트롤러.
 */
@RequestMapping(path = "profile")
@RequiredArgsConstructor
@RestController
public class UserProfileController {

  private final UserProfileUseCase useCase;

  /**
   * 사용자 정보를 조회합니다.
   *
   * @param id 사용자 아이디
   * @return 유효하면 사용자 정보, 나머지 예외
   */
  @GetMapping(path = "{id}")
  public UserProfileResponse find(@PathVariable("id") final long id) {
    return useCase.profile(new UserProfileCommand(id));
  }

}
