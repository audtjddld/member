package com.example.member.adapter.out.h2db;

import com.example.member.application.port.out.FindUserEmailPasswordPort;
import com.example.member.common.Adapter;
import com.example.member.domain.entity.User;
import com.example.member.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

/**
 * 이메일 패스워드로 회원정보 조회 Adapter.
 */
@RequiredArgsConstructor
@Adapter
public class FindUserEmailPasswordAdapter implements FindUserEmailPasswordPort {

  private final UserRepository repository;

  @Transactional(readOnly = true)
  @Override
  public User findByEmailAndPassword(final String email, final String password) {
    return repository.findByEmailAndPassword(email, password);
  }

}
