package com.example.member.adapter.in.web;

import com.example.member.adapter.in.web.model.ValidateAuthenticationNumberRequest;
import com.example.member.adapter.in.web.model.ValidationAuthenticationNumberResponse;
import com.example.member.application.port.in.ValidateAuthenticationNumberUseCase;
import com.example.member.application.port.in.command.ValidateAuthenticationNumberCommand;
import com.example.member.exception.BadRequestException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 인증번호 검증 Controller.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "validations")
public class ValidateAuthenticationNumberController {

  private final ValidateAuthenticationNumberUseCase useCase;

  @PostMapping
  public ValidationAuthenticationNumberResponse validate(
      @Valid @RequestBody final ValidateAuthenticationNumberRequest request,
      final BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      throw new BadRequestException();
    }

    return useCase.validate(new ValidateAuthenticationNumberCommand(
        request.getMobile(),
        request.getAuthenticationNumber())
    );
  }

}
