package com.example.member.domain.repository;

import com.example.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 회원 Repository.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

  /**
   * 이메일로 가입된 회원이 있는지 조회합니다.
   *
   * @param email 이메일
   * @return 가입된 회원이 있으면 회원정보, 없으면 null
   */
  Member findByEmail(String email);

  /**
   * 이메일과 패스워드로 회원 정보를 조회합니다.
   *
   * @param email    이메일
   * @param password 패스워드
   * @return 일치하는 정보가 있으면 회원정보, 나머지 null
   */
  Member findByEmailAndPassword(String email, String password);

}
