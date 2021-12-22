package com.example.member.adapter.out.h2db;

import com.example.member.application.port.out.PersistMemberPort;
import com.example.member.application.port.out.model.PersistMemberCommand;
import com.example.member.common.Adapter;
import com.example.member.domain.entity.Member;
import com.example.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 회원 저장 Adapter.
 */
@RequiredArgsConstructor
@Adapter
public class PersistMemberAdapter implements PersistMemberPort {

  private final MemberRepository repository;

  @Transactional
  @Override
  public Member save(final PersistMemberCommand command) {

    final Member member = Member.builder()
        .password(command.getPassword())
        .name(command.getName())
        .nickname(command.getNickname())
        .mobile(command.getMobile())
        .email(command.getEmail())
        .build();

    return repository.save(member);
  }

}
