package com.example.member.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class JwtManagerTest {

  private final TokenManager tokenManager = new JwtManager("qwerqwer", 250000L);

  @Test
  public void test1() {
    final String token = tokenManager.create(1L, "abc@abc.com");
    final boolean verify = tokenManager.verify(token);
    Assertions.assertTrue(verify);
  }

}
