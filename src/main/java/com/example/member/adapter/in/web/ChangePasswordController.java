package com.example.member.adapter.in.web;

import com.example.member.adapter.in.web.model.ChangePasswordRequest;
import com.example.member.application.port.in.ChangePasswordUseCase;
import com.example.member.application.port.in.command.ChangePasswordCommand;
import com.example.member.exception.BadRequestException;
import java.security.NoSuchAlgorithmException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 패스워드 변경 Controller.
 */
@RequestMapping(path = "users")
@RequiredArgsConstructor
@RestController
public class ChangePasswordController {

  private final ChangePasswordUseCase useCase;

  /**
   * 사용자 패스워드를 변경합니다.
   *
   * @return 변경 성공 200ok, 나머지 예외
   */
  @PutMapping
  public ResponseEntity<Void> update(@Valid @RequestBody final ChangePasswordRequest request,
                                     final BindingResult bindingResult) throws NoSuchAlgorithmException {

    if (bindingResult.hasErrors()) {
      throw new BadRequestException();
    }

    if (!request.getPassword().equals(request.getConfirmPassword())) {
      throw new BadRequestException();
    }

    useCase.change(new ChangePasswordCommand(request.getId(), request.getPassword()));

    return ResponseEntity.ok().build();
  }

}
