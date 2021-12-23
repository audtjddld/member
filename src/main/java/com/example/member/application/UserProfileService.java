package com.example.member.application;

import com.example.member.application.port.in.UserProfileUseCase;
import com.example.member.application.port.in.command.UserProfileCommand;
import com.example.member.application.port.in.command.UserProfileResponse;
import com.example.member.domain.entity.Member;
import com.example.member.domain.repository.MemberRepository;
import com.example.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 유저 프로파일 서비스.
 */
@RequiredArgsConstructor
@Service
public class UserProfileService implements UserProfileUseCase {

  private final MemberRepository repository;

  @Transactional(readOnly = true)
  @Override
  public UserProfileResponse profile(final UserProfileCommand command) {
    final Member member = repository.findById(command.getId())
        .orElseThrow(MemberNotFoundException::new);

    return UserProfileResponse.builder()
        .email(member.getEmail())
        .mobile(member.getMobile())
        .name(member.getName())
        .nickname(member.getNickname())
        .build();
  }

}
