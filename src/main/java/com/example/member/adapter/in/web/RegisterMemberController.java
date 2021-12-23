package com.example.member.adapter.in.web;

import com.example.member.adapter.in.web.model.RegisterMemberRequest;
import com.example.member.application.port.in.RegisterMemberUseCase;
import com.example.member.application.port.in.command.RegisterMemberCommand;
import com.example.member.exception.BadRequestException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 회원 가입 Controller.
 */
@RequiredArgsConstructor
@RequestMapping(path = "members")
@RestController
public class RegisterMemberController {

  private final RegisterMemberUseCase useCase;

  @SneakyThrows
  @PostMapping
  public ResponseEntity<Void> join(@Valid @RequestBody final RegisterMemberRequest request,
                                   final BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      throw new BadRequestException();
    }

    final RegisterMemberCommand command = RegisterMemberCommand.builder()
        .email(request.getEmail())
        .mobile(request.getMobile())
        .name(request.getName())
        .nickname(request.getNickname())
        .password(request.getPassword())
        .build();
    useCase.register(command);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }


}
