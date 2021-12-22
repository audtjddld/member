package com.example.member.application;

import com.example.member.application.port.in.RegisterMemberUseCase;
import com.example.member.application.port.in.command.RegisterMemberCommand;
import com.example.member.application.port.out.FindMemberPort;
import com.example.member.application.port.out.PersistMemberPort;
import com.example.member.application.port.out.model.PersistMemberCommand;
import com.example.member.domain.entity.Member;
import com.example.member.exception.AreadyJoinedMemberException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 회원 정보 저장 UseCase.
 */
@RequiredArgsConstructor
@Service
public class RegisterMemberService implements RegisterMemberUseCase {

  private final PersistMemberPort persistMemberPort;
  private final FindMemberPort findMemberPort;

  @Transactional
  @Override
  public void register(final RegisterMemberCommand command) {
    final Member alreadyJoinedMember = findMemberPort.find(command.getEmail());

    if (Objects.nonNull(alreadyJoinedMember)) {
      throw new AreadyJoinedMemberException();
    }

    final PersistMemberCommand persistMemberCommand = PersistMemberCommand.builder()
        .email(command.getEmail())
        .mobile(command.getMobile())
        .name(command.getName())
        .nickname(command.getNickname())
        .password(command.getPassword())
        .build();

    persistMemberPort.save(persistMemberCommand);

  }

}
