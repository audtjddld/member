package com.example.member.adapter.in.web;

import static com.example.member.utils.ResourceMockUtil.getString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.member.adapter.in.web.model.ValidationAuthenticationNumberResponse;
import com.example.member.application.port.in.ValidateAuthenticationNumberUseCase;
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

@DisplayName("ValidateAuthenticationNumberController 클래스")
@SpringBootTest
class ValidateAuthenticationNumberControllerTest {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  private static final String URL = "/validations";

  @MockBean
  private ValidateAuthenticationNumberUseCase useCase;

  @BeforeEach
  public void setUp() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .alwaysDo(MockMvcResultHandlers.print())
        .build();

    init();
  }

  public void init() {
    given(useCase.validate(any()))
        .willReturn(new ValidationAuthenticationNumberResponse(true));
  }

  @DisplayName("유효성 검사 테스트")
  @Nested
  public class Validation {

    @DisplayName("인증번호 길이가 6자리 이상이면, 400오류를 응답한다.")
    @Test
    public void test1() throws Exception {
      mockMvc.perform(
              post(URL)
                  .contentType(APPLICATION_JSON)
                  .content(getString("인증번호검증_인증번호오류.json")))
          .andExpect(status().is(400));
    }

    @DisplayName("인증번호 길이가 6자리 이하면, 400오류를 응답한다.")
    @Test
    public void test2() throws Exception {
      mockMvc.perform(
              post(URL)
                  .contentType(APPLICATION_JSON)
                  .content(getString("인증번호검증_인증번호길이짧음오류.json")))
          .andExpect(status().is(400));
    }

    @DisplayName("휴대번호 형식이 올바르지 않으면, 400오류를 응답한다.")
    @Test
    public void test3() throws Exception {
      mockMvc.perform(
              post(URL)
                  .contentType(APPLICATION_JSON)
                  .content(getString("인증번호검증_휴대번호오류.json")))
          .andExpect(status().is(400));
    }

  }

}
