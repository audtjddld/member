package com.example.member.adapter.in.web;

import static com.example.member.utils.ResourceMockUtil.getString;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.member.application.port.in.RegisterMemberUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@DisplayName("RegisterMemberController 클래스")
@SpringBootTest
public class RegisterMemberControllerTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  private static final String URL = "/members";

  @MockBean
  private RegisterMemberUseCase useCase;

  public void init() {
    useCase = command -> {
    };
  }

  @BeforeEach
  public void before() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .alwaysDo(MockMvcResultHandlers.print())
        .build();
    init();
  }

  @DisplayName("회원가입 유효성 테스트")
  @Nested
  class Validation {

    @Test
    @DisplayName("이메일 형식이 올바르지 않으면, 400으로 응답을 준다")
    public void test1() throws Exception {
      mockMvc.perform(
              post(URL)
                  .contentType(APPLICATION_JSON)
                  .content(getString("회원가입_이메일형식오류.json")))
          .andExpect(status().is(400));
    }

    @Test
    @DisplayName("휴대번호 형식이 올바르지 않으면, 400으로 응답을 준다")
    public void test2() throws Exception {
      mockMvc.perform(
              post(URL)
                  .contentType(APPLICATION_JSON)
                  .content(getString("회원가입_휴대번호오류.json")))
          .andExpect(status().is(400));
    }

    @Test
    @DisplayName("성명 형식이 올바르지 않으면, 400으로 응답을 준다")
    public void test3() throws Exception {
      mockMvc.perform(
              post(URL)
                  .contentType(APPLICATION_JSON)
                  .content(getString("회원가입_성명오류.json")))
          .andExpect(status().is(400));
    }

    @Test
    @DisplayName("닉네임 형식이 올바르지 않으면, 400으로 응답을 준다")
    public void test4() throws Exception {
      mockMvc.perform(
              post(URL)
                  .contentType(APPLICATION_JSON)
                  .content(getString("회원가입_닉네임오류.json")))
          .andExpect(status().is(400));
    }

    @Test
    @DisplayName("패스워드가 빈값으로 들어오면, 400으로 응답을 준다")
    public void test5() throws Exception {
      mockMvc.perform(
              post(URL)
                  .contentType(APPLICATION_JSON)
                  .content(getString("회원가입_패스워드오류.json")))
          .andExpect(status().is(400));
    }

  }

}
