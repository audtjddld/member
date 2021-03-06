package com.example.member.adapter.out.h2db;

import com.example.member.application.port.out.FindUserPort;
import com.example.member.common.Adapter;
import com.example.member.domain.entity.User;
import com.example.member.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * ํ์ ์กฐํ Adapter.
 */
@RequiredArgsConstructor
@Adapter
public class FindUserAdapter implements FindUserPort {

  private final UserRepository repository;

  @Override
  public User find(final String email) {
    return repository.findByEmail(email);
  }

}
