package com.example.member.application;

import com.example.member.application.port.in.ChangePasswordUseCase;
import com.example.member.application.port.in.command.ChangePasswordCommand;
import com.example.member.domain.entity.User;
import com.example.member.domain.repository.UserRepository;
import java.security.NoSuchAlgorithmException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@Sql("/init.sql")
@DisplayName("ChangePasswordService 클래스")
@SpringBootTest
class ChangePasswordServiceTest {

  @Autowired
  private ChangePasswordUseCase useCase;

  @Autowired
  private UserRepository repository;


  @Test
  @DisplayName("기존에 등록한 사용자의 비밀번호 변경하고 조회하면 변경된 비밀번호로 조회 됩니다.")
  public void test1() throws NoSuchAlgorithmException {
    User user = repository.findById(1L).get();
    final String prevPassword = user.getPassword();

    final ChangePasswordCommand changePasswordCommand =
        new ChangePasswordCommand(1, "1234");

    useCase.change(changePasswordCommand);

    user = repository.findById(1L).get();

    System.out.println(prevPassword);
    final String changedPassword = user.getPassword();
    System.out.println(changedPassword);
    Assertions.assertNotEquals(prevPassword, changedPassword);
  }


}
