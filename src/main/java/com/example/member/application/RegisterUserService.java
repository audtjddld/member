package com.example.member.application;

import com.example.member.application.port.in.RegisterUserUseCase;
import com.example.member.application.port.in.command.RegisterMemberCommand;
import com.example.member.application.port.out.FindUserPort;
import com.example.member.application.port.out.PersistUserPort;
import com.example.member.application.port.out.model.PersistMemberCommand;
import com.example.member.domain.entity.User;
import com.example.member.domain.util.SHA256;
import com.example.member.exception.AreadyJoinedMemberException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 회원 정보 저장 UseCase.
 */
@RequiredArgsConstructor
@Service
public class RegisterUserService implements RegisterUserUseCase {

  private final PersistUserPort persistUserPort;
  private final FindUserPort findUserPort;

  @Transactional
  @Override
  public void register(final RegisterMemberCommand command) throws NoSuchAlgorithmException {
    final User alreadyJoinedUser = findUserPort.find(command.getEmail());

    if (Objects.nonNull(alreadyJoinedUser)) {
      throw new AreadyJoinedMemberException();
    }

    final PersistMemberCommand persistMemberCommand = PersistMemberCommand.builder()
        .email(command.getEmail())
        .mobile(command.getMobile())
        .name(command.getName())
        .nickname(command.getNickname())
        .password(SHA256.encrypt(command.getPassword()))
        .build();

    persistUserPort.save(persistMemberCommand);

  }

}
