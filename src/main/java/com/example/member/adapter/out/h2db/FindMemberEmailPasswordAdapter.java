package com.example.member.adapter.out.h2db;

import com.example.member.application.port.out.FindMemberEmailPasswordPort;
import com.example.member.common.Adapter;
import com.example.member.domain.entity.Member;
import com.example.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 이메일 패스워드로 회원정보 조회 Adapter.
 */
@RequiredArgsConstructor
@Adapter
public class FindMemberEmailPasswordAdapter implements FindMemberEmailPasswordPort {

  private final MemberRepository repository;

  @Transactional(readOnly = true)
  @Override
  public Member findByEmailAndPassword(final String email, final String password) {
    return repository.findByEmailAndPassword(email, password);
  }

}
