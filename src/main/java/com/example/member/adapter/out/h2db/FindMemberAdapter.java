package com.example.member.adapter.out.h2db;

import com.example.member.application.port.out.FindUserPort;
import com.example.member.common.Adapter;
import com.example.member.domain.entity.User;
import com.example.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

/**
 * 회원 조회 Adapter.
 */
@RequiredArgsConstructor
@Adapter
public class FindMemberAdapter implements FindUserPort {

  private final MemberRepository repository;

  @Override
  public User find(final String email) {
    return repository.findByEmail(email);
  }

}
