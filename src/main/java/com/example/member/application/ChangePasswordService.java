package com.example.member.application;

import com.example.member.application.port.in.ChangePasswordUseCase;
import com.example.member.application.port.in.command.ChangePasswordCommand;
import com.example.member.domain.entity.Member;
import com.example.member.domain.repository.MemberRepository;
import com.example.member.domain.util.SHA256;
import com.example.member.exception.MemberNotFoundException;
import java.security.NoSuchAlgorithmException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 패스워드 변경 서비스.
 */
@RequiredArgsConstructor
@Service
public class ChangePasswordService implements ChangePasswordUseCase {

  private final MemberRepository repository;

  @Transactional
  @Override
  public void change(final ChangePasswordCommand command) throws NoSuchAlgorithmException {
    final Member member = repository.findById(command.getId())
        .orElseThrow(MemberNotFoundException::new);

    member.updatePassword(SHA256.encrypt(command.getPassword()));
  }

}
