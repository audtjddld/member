package com.example.member.adapter.out.h2db;

import com.example.member.application.port.out.PersistUserPort;
import com.example.member.application.port.out.model.PersistMemberCommand;
import com.example.member.common.Adapter;
import com.example.member.domain.entity.User;
import com.example.member.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 회원 저장 Adapter.
 */
@RequiredArgsConstructor
@Adapter
public class PersistUserAdapter implements PersistUserPort {

  private final UserRepository repository;

  @Transactional
  @Override
  public User save(final PersistMemberCommand command) {

    final User user = User.builder()
        .password(command.getPassword())
        .name(command.getName())
        .nickname(command.getNickname())
        .mobile(command.getMobile())
        .email(command.getEmail())
        .build();

    return repository.save(user);
  }

}
